function Ajax(url,data){
    this.url=url;
    this.data=data;
  };
Ajax.prototype={
    get:function(){
        var result;
        var xmlhttp;
       var xmlhttp=getXMLHttpRequest();
        xmlhttp.onreadystatechange=function(){
            result = xmlhttp.responseText;//闭包，不能采用this.属性
        };
        xmlhttp.open('GET',this.url+'?'+this.data,false);//true无法抓取数据，why?
        xmlhttp.send(null);
        return result;
    },
    post:function(){
        var result;
        var xmlhttp=getXMLHttpRequest();
         xmlhttp.onreadystatechange=function(){
            result = xmlhttp.responseText;//闭包，不能采用this.属性
        };
        //xmlhttp.open('POST',this.url+'?'+this.data,false);//需设为false,否则无法抓取responseText
        xmlhttp.open('POST',this.url,false);//需设为false,否则无法抓取responseText
        xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");//POST中，这句必须
//        this.data=encodeURI(this.data);
//		this.data=encodeURI(this.data); //两次编码
        xmlhttp.send(this.data);
        return result;
    }
};
function getXMLHttpRequest() {
        var xmlhttp;
		if (window.XMLHttpRequest) {
			try {
				xmlhttp = new XMLHttpRequest();
				xmlhttp.overrideMimeType("text/html;charset=GBK");//设定以UTF-8编码识别数据
			} catch (e) {}
		} else if (window.ActiveXObject) {
			try {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				try {
					xmlhttp = new ActiveXObject("Msxml2.XMLHttp");
				} catch (e) {
					try {
						xmlhttp = new ActiveXObject("Msxml3.XMLHttp");
					} catch (e) {}
				}
			}
		}
        return xmlhttp;
}
