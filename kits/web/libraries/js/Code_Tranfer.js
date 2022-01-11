/* 小写金额转换成大写（人民币元）
入参（P1）：dValue 金额数值或数值字符串
  a, 也支持千分位格式（#,##0.00）输入；
  b, 支持负数，将前导“-”号转为“负”字，将前导的“+”号忽略或转为“正”字；
  c1, 值域之整数部分上限（超限则返回错误）：
  44位/千正；43位/百正；42位/十正；   
  41位/【正】即万涧即亿亿亿亿亿（10^40，1正=1万涧=1亿亿亿亿亿=10,000,000,000,000,000,000,000,000,000,000,000,000,000）；40位/千涧；39位/百涧；38位/十涧；   
  37位/【涧】即万涧即万亿亿亿亿（10^36，1涧=1万沟=1万亿亿亿亿=1,000,000,000,000,000,000,000,000,000,000,000,000）；36位/千沟；35位/百沟；34位/十沟；
  33位/【沟】即万穰即亿亿亿亿（10^32，1沟=1万杼=1亿亿亿亿=100,000,000,000,000,000,000,000,000,000,000）；31位/千穰；30位/百穰；29位/十穰；   
  29位/【穰】即万杼即万亿亿亿（10^28，1穰=1万杼=1万亿亿亿=10,000,000,000,000,000,000,000,000,000）；28位/千杼；27位/百杼；26位/十杼；
  25位/【杼】即万垓即亿亿亿（10^24，1杼=1万垓=1亿亿亿=1,000,000,000,000,000,000,000,000）；24位/千垓；23位/百垓；22位/十垓；
  21位/【垓】即万京即万亿亿（10^20，1垓=1万京=1万亿亿=100,000,000,000,000,000,000）；20位/千京；19位/百京；18位/十京；
  17位/【京】即万兆即亿亿（10^16，1京=1万兆=1亿亿=10,000,000,000,000,000）；16位/千兆；15位/百兆；14位/十兆；
  13位/【兆】即万亿（10^12，1兆=1万亿=1,000,000,000,000）；12位/千亿；11位/百亿；10位/十亿；
  9位/【亿】（10^8，1亿=1万万=100,000,000）；8位/千万；7位/百万；6位/十万；
  5位/【万】（10^4，1万=10,000）；4位/千；3位/百；2位/十；1位/个。
  c2, 值域之小数部分上限：5位或用户参数指定（角/分/厘/毫/丝，超限则四舍五入）。
入参（P1）：maxDec 精确小数位数（值域0~5，不指定则默认为2，超限归为默认）。
用法：AmountInWords(890123456789.123456) AmountInWords(324,567,890,123.45) AmountInWords(123.00) AmountInWords(0.67)
  -10,090,008,000,700,060,005,000,400,030,002,000,100,000,000.123456 = 负壹仟零玖正零捌涧零柒沟零陆穰零伍杼零肆垓零叁京零贰兆零壹亿元壹角贰分叁厘肆毫陆丝
  12,345,678,901,234,567,890,123,456,789,012,345,678,901,234.123456 = 壹仟贰佰叁拾肆正伍仟陆佰柒拾捌涧玖仟零壹拾贰沟叁仟肆佰伍拾陆穰柒仟捌佰玖拾杼零壹仟贰佰叁拾肆垓伍仟陆佰柒拾捌京玖仟零壹拾贰兆叁仟肆佰伍拾陆亿柒仟捌佰玖拾万零壹仟贰佰叁拾肆元壹角贰分叁厘肆毫陆丝
返回：大写字符串
更新：冉志军 2008-02-27 12:44
更新说明：整数由11位（百亿）扩展至44位/千正/10^43（注：1正=1万涧=1亿亿亿亿亿，10^40）；小数由2位（分/10^-2）扩展至5位（丝/10^-5）并可通过参数自定义；支持正负号；出错不再弹出窗口而改为直接返回返回文本。
 */
function AmountInWords(dValue, maxDec) {
	// 验证输入金额数值或数值字符串：
	dValue = dValue.toString().replace(/,/g, "");
	dValue = dValue.replace(/^0+/, ""); // 金额数值转字符、移除逗号、移除前导零
	if (dValue == "") {
		return "零元整";
	} // （错误：金额为空！）
	else if (isNaN(dValue)) {
		return "错误：金额不是合法的数值！";
	}

	var minus = ""; // 负数的符号“-”的大写：“负”字。可自定义字符，如“（负）”。
	var CN_SYMBOL = ""; // 币种名称（如“人民币”，默认空）
	if (dValue.length > 1) {
		if (dValue.indexOf('-') == 0) {
			dValue = dValue.replace("-", "");
			minus = "负";
		} // 处理负数符号“-”
		if (dValue.indexOf('+') == 0) {
			dValue = dValue.replace("+", "");
		} // 处理前导正数符号“+”（无实际意义）
	}

	// 变量定义：
	var vInt = "";
	var vDec = ""; // 字符串：金额的整数部分、小数部分
	var resAIW; // 字符串：要输出的结果
	var parts; // 数组（整数部分.小数部分），length=1时则仅为整数。
	var digits, radices, bigRadices, decimals; // 数组：数字（0~9——零~玖）；基（十进制记数系统中每个数字位的基是10——拾,佰,仟）；大基（万,亿,兆,京,垓,杼,穰,沟,涧,正）；辅币（元以下，角/分/厘/毫/丝）。
	var zeroCount; // 零计数
	var i, p, d; // 循环因子；前一位数字；当前位数字。
	var quotient, modulus; // 整数部分计算用：商数、模数。
	// 金额数值转换为字符，分割整数部分和小数部分：整数、小数分开来搞（小数部分有可能四舍五入后对整数部分有进位）。
	var NoneDecLen = (typeof (maxDec) == "undefined" || maxDec == null
			|| Number(maxDec) < 0 || Number(maxDec) > 5); // 是否未指定有效小数位（true/false）
	parts = dValue.split('.'); // 数组赋值：（整数部分.小数部分），Array的length=1则仅为整数。
	if (parts.length > 1) {
		vInt = parts[0];
		vDec = parts[1]; // 变量赋值：金额的整数部分、小数部分

		if (NoneDecLen) {
			maxDec = vDec.length > 5 ? 5 : vDec.length;
		} // 未指定有效小数位参数值时，自动取实际小数位长但不超5。
		var rDec = Number("0." + vDec);
		rDec *= Math.pow(10, maxDec);
		rDec = Math.round(Math.abs(rDec));
		rDec /= Math.pow(10, maxDec); // 小数四舍五入
		var aIntDec = rDec.toString().split('.');
		/*
		 * 以下这句当整数位长超16位时，js中的Number()转换及运算会导致精度丧失： vInt = (Number(vInt) +
		 * 1).toString(); 可用Ajax待方式到服务器上计算。
		 */
		if (Number(aIntDec[0]) == 1) {
			vInt = (Number(vInt) + 1).toString();
		} // 小数部分四舍五入后有可能向整数部分的个位进位（值1）

		if (aIntDec.length > 1) {
			vDec = aIntDec[1];
		} else {
			vDec = "";
		}
	} else {
		vInt = dValue;
		vDec = "";
		if (NoneDecLen) {
			maxDec = 0;
		}
	}
	if (vInt.length > 44) {
		return "错误：金额值太大了！整数位长【" + vInt.length.toString()
				+ "】超过了上限——44位/千正/10^43（注：1正=1万涧=1亿亿亿亿亿，10^40）！";
	}

	// 准备各字符数组 Prepare the characters corresponding to the digits:
	digits = new Array("零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"); // 零~玖
	radices = new Array("", "拾", "佰", "仟"); // 拾,佰,仟
	bigRadices = new Array("", "万", "亿", "兆", "京", "垓", "杼", "穰", "沟", "涧", "正"); // 万,亿,兆,京,垓,杼,穰,沟,涧,正
	decimals = new Array("角", "分", "厘", "毫", "丝"); // 角/分/厘/毫/丝

	resAIW = ""; // 开始处理

	// 处理整数部分（如果有）
	if (Number(vInt) > 0) {
		zeroCount = 0;
		for (i = 0; i < vInt.length; i++) {
			p = vInt.length - i - 1;
			d = vInt.substr(i, 1);
			quotient = p / 4;
			modulus = p % 4;
			if (d == "0") {
				zeroCount++;
			} else {
				if (zeroCount > 0) {
					resAIW += digits[0];
				}
				zeroCount = 0;
				resAIW += digits[Number(d)] + radices[modulus];
			}
			if (modulus == 0 && zeroCount < 4) {
				resAIW += bigRadices[quotient];
			}
		}
		resAIW += "元";
	}

	// 处理小数部分（如果有）
	for (i = 0; i < vDec.length; i++) {
		d = vDec.substr(i, 1);
		if (d != "0") {
			resAIW += digits[Number(d)] + decimals[i];
		}
	}

	// 处理结果
	if (resAIW == "") {
		resAIW = "零" + "元";
	} // 零元
	if (vDec == "") {
		resAIW += "整";
	} // ...元整
	resAIW = CN_SYMBOL + minus + resAIW; // 人民币/负......元角分/整
	return resAIW;

	// 备注：
	/***************************************************************************
	 * 丝 .... 10^-5 ...... 0.00001 毫 .... 10^-4 ...... 0.0001 厘 .... 10^-3
	 * ...... 0.001 分 .... 10^-2 ...... 0.01 角 .... 10^-1 ...... 0.1
	 * ----------------------------- 个位（元）10^0 1 ----------------------------- 拾
	 * .... 10^1 ...... 10 佰 .... 10^2 ...... 100 仟 .... 10^3 ...... 1,000 万
	 * .... 10^4 ...... 10,000 亿 .... 10^8 ...... 100,000,000 兆 .... 10^12 .....
	 * 1,000,000,000,000 京 .... 10^16 ..... 10,000,000,000,000,000 垓 .... 10^20
	 * ..... 100,000,000,000,000,000,000 gāi 杼 .... 10^24 .....
	 * 1,000,000,000,000,000,000,000,000 zhù 穰 .... 10^28 .....
	 * 10,000,000,000,000,000,000,000,000,000 rǎng 国际制用“艾可萨”,简称“艾”,符号E 沟 ....
	 * 10^32 ..... 100,000,000,000,000,000,000,000,000,000,000 涧 .... 10^36
	 * ..... 1,000,000,000,000,000,000,000,000,000,000,000,000 正 .... 10^40
	 * ..... 10,000,000,000,000,000,000,000,000,000,000,000,000,000 载 .... 10^44
	 * 极 .... 10^48 恒河沙 ..... 10^52 阿僧祇 ..... 10^56 那由他 ..... 10^60 不可思议 ...
	 * 10^64 无量 ....... 10^68 大数 ....... 10^72
	 **************************************************************************/
}
/** 将数字转换成大写人民币* */
function cmycurd(num) { // 转成人民币大写金额形式
	var str1 = '零壹贰叁肆伍陆柒捌玖'; // 0-9所对应的汉字
	var str2 = '万仟佰拾亿仟佰拾万仟佰拾元角分'; // 数字位所对应的汉字
	var str3; // 从原num值中取出的值
	var str4; // 数字的字符串形式
	var str5 = ''; // 人民币大写金额形式
	var i; // 循环变量
	var j; // num的值乘以100的字符串长度
	var ch1; // 数字的汉语读法
	var ch2; // 数字位的汉字读法
	var nzero = 0; // 用来计算连续的零值是几个

	num = Math.abs(num).toFixed(2); // 将num取绝对值并四舍五入取2位小数
	str4 = (num * 100).toFixed(0).toString(); // 将num乘100并转换成字符串形式
	j = str4.length; // 找出最高位
	if (j > 15) {
		return '溢出';
	}
	str2 = str2.substr(15 - j); // 取出对应位数的str2的值。如：200.55,j为5所以str2=佰拾元角分

	// 循环取出每一位需要转换的值
	for (i = 0; i < j; i++) {
		str3 = str4.substr(i, 1); // 取出需转换的某一位的值
		if (i != (j - 3) && i != (j - 7) && i != (j - 11) && i != (j - 15)) { // 当所取位数不为元、万、亿、万亿上的数字时
			if (str3 == '0') {
				ch1 = '';
				ch2 = '';
				nzero = nzero + 1;
			} else {
				if (str3 != '0' && nzero != 0) {
					ch1 = '零' + str1.substr(str3 * 1, 1);
					ch2 = str2.substr(i, 1);
					nzero = 0;
				} else {
					ch1 = str1.substr(str3 * 1, 1);
					ch2 = str2.substr(i, 1);
					nzero = 0;
				}
			}
		} else { // 该位是万亿，亿，万，元位等关键位
			if (str3 != '0' && nzero != 0) {
				ch1 = "零" + str1.substr(str3 * 1, 1);
				ch2 = str2.substr(i, 1);
				nzero = 0;
			} else {
				if (str3 != '0' && nzero == 0) {
					ch1 = str1.substr(str3 * 1, 1);
					ch2 = str2.substr(i, 1);
					nzero = 0;
				} else {
					if (str3 == '0' && nzero >= 3) {
						ch1 = '';
						ch2 = '';
						nzero = nzero + 1;
					} else {
						if (j >= 11) {
							ch1 = '';
							nzero = nzero + 1;
						} else {
							ch1 = '';
							ch2 = str2.substr(i, 1);
							nzero = nzero + 1;
						}
					}
				}
			}
		}
		if (i == (j - 11) || i == (j - 3)) { // 如果该位是亿位或元位，则必须写上
			ch2 = str2.substr(i, 1);
		}
		str5 = str5 + ch1 + ch2;

		if (i == j - 1 && str3 == '0') { // 最后一位（分）为0时，加上“整”
			str5 = str5 + '整';
		}
	}
	if (num == 0) {
		str5 = '零元整';
	}
	return str5;
}
//除法函数，用来得到精确的除法结果 
function accDiv(arg1, arg2) {
	var t1 = 0, t2 = 0, r1, r2;
	try {
		t1 = arg1.toString().split(".")[1].length;
	} catch (e) {
	}
	try {
		t2 = arg2.toString().split(".")[1].length;
	} catch (e) {
	}
	with (Math) {
		r1 = Number(arg1.toString().replace(".", ""));
		r2 = Number(arg2.toString().replace(".", ""));
		return (r1 / r2) * pow(10, t2 - t1);
	}
}
Number.prototype.div = function(arg) {
	return accDiv(arg, this);
};
// 乘法函数，用来得到精确的乘法结果
function accMul(arg1, arg2) {
	var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
	try {
		m += s1.split(".")[1].length;
	} catch (e) {
	}
	try {
		m += s2.split(".")[1].length;
	} catch (e) {
	}
	return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
}
// 给Number类型增加一个mul方法，调用起来更加方便。
Number.prototype.mul = function(arg) {
	return accMul(arg, this);
};
// 加法函数，用来得到精确的加法结果
function accAdd(arg1, arg2) {
	var r1, r2, m;
	try {
		r1 = arg1.toString().split(".")[1].length;
	} catch (e) {
		r1 = 0;
	}
	try {
		r2 = arg2.toString().split(".")[1].length;
	} catch (e) {
		r2 = 0;
	}
	m = Math.pow(10, Math.max(r1, r2));
	return (arg1 * m + arg2 * m) / m;
}
//给Number类型增加一个add方法，调用起来更加方便。 
Number.prototype.add = function(arg) {
	return accAdd(arg, this);
};


