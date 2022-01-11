var app = angular.module('myApp', ['ngResource']);
app
		.controller(
				'myCtrl',
				function($scope, $http,$resource) {
					var baseUrl="http://192.168.1.77:8080/";
					$scope.company = '';
					$scope.search = function() {

						if ($scope.billNo != "" && $scope.billNo != undefined) {
							var urlget = baseUrl+"xyt-platform/online/inms/company/match/"+$scope.billNo;
							var resource = $resource(urlget + ':billNo', {}, {
								query : {
									method : 'get',
									isArray : false
								}
							});
							resource.query(
								$scope.billNo
							, function(r) {
								console.log(r);
								result = r;
								$scope.company=r.dataset;
								if(r.dataset.length==0){
									alert("未找到该运单信息");
								}
							})
						} else {
							$('.conceal').remove();
							alert("请输入运单号");
						}
					}
					$scope.wayDetail = function(wayId) {
						if (wayId != "" && wayId != undefined) {
							var locateUrl = JSON
									.stringify(baseUrl+"xyt-platform/html/scanning.html?wayId="
											+ wayId);
							setTimeout("location.href =" + locateUrl, 1);
						} else {
							alert("未找到该运单信息");
						}
					}
				});



