(function() {
	var BLANK_PATH = "about:blank";
	dorado.widget.IFrame = $extend(
			dorado.widget.Control,
			{
				$className : "dorado.widget.IFrame",
				ATTRIBUTES : {
					className : {
						defaultValue : "d-iframe"
					},
					name : {
						writeBeforeReady : true
					},
					path : {
						skipRefresh : true,
						setter : function(value) {
							var frame = this, oldPath = frame._path, dom = frame._dom, doms = frame._doms;
							if (oldPath == value) {
								return;
							}
							frame._path = value;
							if (dom) {
								$fly(doms.loadingCover).css("display", "block");
								frame.releaseCurrentPage();
								$fly(doms.iframe).addClass("hidden");
								if (oldPath != value) {
									frame._loaded = false;
								}
								if (frame.isActualVisible()) {
									frame.replaceUrl(value);
								} else {
									frame._toReplaceUrl = value;
								}
							}
						}
					},
					iFrameWindow : {
						readOnly : true,
						getter : function() {
							return this.getIFrameWindow();
						}
					}
				},
				EVENTS : {
					onLoad : {}
				},
				getDomainInfo : function(domain) {
					var regex = /^(http[s]?):\/\/([\w.]+)(:([\d]+))?/ig, result = regex
							.exec(domain);
					if (result) {
						return {
							protocol : result[1],
							domain : result[2],
							port : result[4]
						};
					} else {
						return {};
					}
				},
				isSameDomain : function() {
					var iframeSrc = $url(this._path);
					if (/^(http[s]?|file):/ig.test(iframeSrc)) {
						var localDomain = this.getDomainInfo(location.href), frameDomain = this
								.getDomainInfo(iframeSrc);
						return localDomain.protocol == frameDomain.protocol
								&& localDomain.domain == frameDomain.domain
								&& localDomain.port == frameDomain.port;
					}
					return true;
				},
				releaseCurrentPage : function() {
					var frame = this, doms = frame._doms;
					if (doms) {
						try {
							if (frame.isSameDomain()) {
								if (doms.iframe.contentWindow.dorado) {
									doms.iframe.contentWindow.dorado.cleanContentOnClose = true;
									doms.iframe.contentWindow.dorado.Exception.IGNORE_ALL_EXCEPTIONS = true;
								}
								if (dorado.Browser.msie) {
									doms.iframe.contentWindow.close();
									CollectGarbage();
								} else {
									doms.iframe.contentWindow.close();
								}
							} else {
								frame.replaceUrl(null);
							}
						} catch (e) {
						}
					}
				},
				destroy : function() {
					var frame = this, doms = frame._doms;
					frame.releaseCurrentPage();
					if (doms) {
						$fly(doms.iframe).remove();
					}
					$invokeSuper.call(frame);
				},
				createDom : function() {
					var frame = this, doms = {}, dom = $DomUtils.xCreate({
						tagName : "div",
						content : [ {
							tagName : "iframe",
							className : "iframe hidden",
							contextKey : "iframe",
							scrolling : dorado.Browser.iOS ? "no" : "auto",
							frameBorder : 0

						}, {
							tagName : "div",
							contextKey : "loadingCover",
							className : "frame-loading-cover",
							style : {
								display : "none"
							},
							content : [ {
								tagName : "div",
								className : "frame-loading-image",
								contextKey : "loadingCoverImg",
								content : {
									tagName : "div",
									className : "spinner"
								}
							},{
								tagName : "div",
								className : "frame-loading-image",
								contextKey : "loadingCoverText",
								style : {
									color : "#FD9C4D",
									fontSize : "larger",
									fontWeight:"550",
									marginTop:"40px",
									marginLeft:"-65px",
								},
								content: {
									width:"200px",
									content: "网络正在加载中..."
								}
							} ]
						}

						]
					}, null, doms);
					if (frame._name != undefined) {
						doms.iframe.name = frame._name || "";
					}
					frame._doms = doms;
					return dom;
				},
				doOnAttachToDocument : function() {
					var frame = this, doms = frame._doms, iframe = doms.iframe;
					$fly(iframe)
							.load(
									function() {
										$fly(doms.loadingCover).css("display",
												"none");
										if (!(dorado.Browser.msie && dorado.Browser.version == 6)) {
											$fly(iframe).removeClass("hidden");
										}
										if (!frame.isActualVisible()) {
											frame._notifyResizeOnVisible = true;
											frame.onActualVisibleChange();
										}
										frame.fireEvent("onLoad", frame);
										if (frame.isSameDomain()) {
											if (frame._replacedUrl
													&& frame._replacedUrl != BLANK_PATH) {
												frame._loaded = true;
											}
										} else {
											if (iframe.src
													&& iframe.src != BLANK_PATH) {
												frame._loaded = true;
											}
										}
									});
					frame.doLoad();
				},
				replaceUrl : function(url) {
					var frame = this, doms = frame._doms, replacedUrl = $url(url
							|| BLANK_PATH);
					delete frame._notifyResizeOnVisible;
					if (frame.isSameDomain()) {
						frame._replacedUrl = replacedUrl;
						if (frame.getIFrameWindow()) {
							frame.getIFrameWindow().location
									.replace(replacedUrl);
						}
					} else {
						$fly(doms.iframe).prop("src", replacedUrl);
					}
				},
				doLoad : function() {
					var frame = this, doms = frame._doms;
					$fly(doms.loadingCover).css("display", "");
					if (frame._path) {
						this.replaceUrl(frame._path);
					}
				},
				reloadIfNotLoaded : function() {
					var frame = this;
					if (!frame._loaded && frame._path) {
						frame.doLoad();
					}
				},
				cancelLoad : function() {
					this.replaceUrl(null);
				},
				doOnResize : function() {
					if (dorado.Browser.isTouch) {
						$fly(this._doms.iframe).css({
							width : this._dom.clientWidth,
							height : this._dom.clientHeight
						});
					}
				},
				reload : function() {
					var frame = this;
					if (dorado.Browser.msie && dorado.Browser.version < 8) {
						frame.releaseCurrentPage();
						frame.replaceUrl(null);
					}
					frame.replaceUrl(frame._path);
				},
				onActualVisibleChange : function() {
					function resizeSubView(subView) {
						subView._children.each(function(child) {
							if (child.resetDimension && child._rendered
									&& child._visible) {
								child.resetDimension();
							}
						});
					}
					$invokeSuper.call(this, arguments);
					var frame = this, actualVisible = frame.isActualVisible();
					if (frame._toReplaceUrl) {
						if (actualVisible) {
							setTimeout(function() {
								if (frame._toReplaceUrl) {
									frame.replaceUrl(frame._toReplaceUrl);
									frame._toReplaceUrl = null;
								}
							}, 10);
							return;
						} else {
							return;
						}
					}
					if (dorado.Browser.isTouch) {
						var frameDom = frame._dom;
						if (actualVisible === false) {
							var frameWin = frame.getIFrameWindow();
							if (frame.isSameDomain() && frameWin) {
								if (frameWin.document.activeElement) {
									frameWin.document.activeElement.blur();
								}
								$fly(frameWin.document.body).find("input")
										.blur();
							}
						}
					}
					if (dorado.Browser.android) {
						return;
					}
					var iframeWindow = frame.getIFrameWindow();
					if (frame._ready && frame._loaded && frame.isSameDomain()) {
						if (iframeWindow && iframeWindow.$topView
								&& iframeWindow.dorado
								&& iframeWindow.dorado.widget) {
							if (dorado.Browser.chrome || dorado.Browser.android) {
								setTimeout(function() {
									if (!iframeWindow.document
											|| !iframeWindow.document.body) {
										return;
									}
									iframeWindow.$topView
											.setActualVisible(actualVisible);
									if (frame._notifyResizeOnVisible
											&& actualVisible) {
										resizeSubView(iframeWindow.$topView);
									}
								}, 50);
							} else {
								if (!iframeWindow.document
										|| !iframeWindow.document.body) {
									return;
								}
								iframeWindow.$topView
										.setActualVisible(actualVisible);
								if (frame._notifyResizeOnVisible
										&& actualVisible) {
									resizeSubView(iframeWindow.$topView);
								}
							}
						}
					}
				},
				getIFrameWindow : function() {
					var frame = this, doms = frame._doms || {}, contentWindow = null;
					try {
						if (doms.iframe) {
							contentWindow = doms.iframe.contentWindow;
						}
					} catch (e) {
					}
					return contentWindow;
				}
			});
})();