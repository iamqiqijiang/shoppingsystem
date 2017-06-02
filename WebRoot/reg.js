//定义了城市的二维数组，里面的顺序跟省份的顺序是相同的。通过selectedIndex获得省份的下标值来得到相应的城市数组    
        var city=[    
            ["北京","天津","上海","重庆"],  
            ["南京市","徐州市","连云港市","宿迁市","淮安市","扬州市","盐城市","南通市","泰州市","苏州市","常州市","无锡市","镇江市"],  
            ["泉州市","三明市","南平市","龙岩市","漳州市","宁德市","莆田市","福州市"],  
            ["广州市","深圳市","珠海市","汕头市","韶关市","佛山市","江门市","湛江市","茂名市","肇庆市","惠州市","梅州市","汕尾市","河源市","阳江市","清远市","东莞市","中山市","潮州市","揭阳市","云浮市"],  
            ["兰州市","嘉峪关市","金昌市","白银市","天水市","武威市","张掖市","酒泉市","平凉市","庆阳市","定西市","陇南市"],
            ["石家庄市","唐山市","秦皇岛市","邯郸市","邢台市","保定市","张家口市","承德市","沧州市","廊坊市","衡水市"],
            ["长沙市","常德市","郴州市","衡阳市","怀化市","娄底市","邵阳市","湘潭市","益阳市","永州市","岳阳市","张家界市","株洲市"]  
        ];    
        function getCity(){    
            //获得省份下拉框的对象    
            var sltProvince=document.form1.province;  
            //获得城市下拉框的对象    
            var sltCity=document.form1.city;    
            //得到对应省份的城市数组    
            var provinceCity=city[sltProvince.selectedIndex - 1];    
            //清空城市下拉框，仅留提示选项    
            sltCity.length=1;    
            //将城市数组中的值填充到城市下拉框中    
            for(var i=0;i<provinceCity.length;i++){    
                sltCity[i+1]=new Option(provinceCity[i],provinceCity[i]);    
                }    
        }    
function check(){
	if(form1.username.value==""){
		alert("用户名不能为空！");
		form1.username.focus();
		return false;
	}
	if(form1.password.value==""){
		alert("密码不能为空！");
		form1.password.focus();
		return false;
	}
	if(form1.password1.value==""){
		alert("确认密码不能为空！");
		form1.password1.focus();
		return false;
	}
	if(form1.password.value!=form1.password1.value){
		alert("密码与确认密码不一致！");
		form1.password.focus();
		return false;
	}
	if((form1.email.value.indexOf('@',0)==-1)||(form1.email.value.indexOf('@',0)==-1)){
		alert("电子邮箱格式不正确！");
		form1.email.focus();
		return false;
	}
	var cates = document.getElementsByName("cate");    
    for(var i=0;i<cates.length;i++)  
    {    
        if(cates[i].checked)  
        {   
        	if(cates[i].value=="顾客"){
        		if(form1.name.value==""){
        			alert("收货人不能为空！");
        			form1.name.focus();
        			return false;
        		}
        		if(form1.phone.value==""){
        			alert("联系电话不能为空！");
        			form1.phone.focus();
        			return false;
        		}
        		if(form1.address.value==""){
        			alert("收货地址不能为空！");
        			form1.address.focus();
        			return false;
        		} 
        	}else if(cates[i].value=="店主"){
        		if(form1.shopname.value==""){
        			alert("店名不能为空，请起一个好听的名字！");
        			form1.shopname.focus();
        			return false;
        		}
        		if(form1.name.value==""){
        			alert("店主姓名不能为空！");
        			form1.name.focus();
        			return false;
        		}
        		if(form1.id.value==""){
        			alert("身份证号不能为空！");
        			form1.id.focus();
        			return false;
        		}
        		if(form1.agree.value=="不同意"){
        			alert("请同意诚信经营承诺书！");
        			return false;
        		}
        	}
        } 
    }   
	
}
function changecus()
{
	document.getElementById("cus").style.display="block";  
	document.getElementById("shop").style.display="none";
}
function changeshop()
{
	 document.getElementById("cus").style.display="none";  
	 document.getElementById("shop").style.display="block";
}
