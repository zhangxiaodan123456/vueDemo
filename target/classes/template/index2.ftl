<html>
 <head>
   <meta charset="utf-8"/>
   <script src="../static/js/jquery.min.js"></script>
 </head>


<body >
   <input type="button" value="click" onclick="test()"/>
   
   
<script type="text/javascript">
  Date.prototype.format = function(fmt) { 
     var o = { 
        "M+" : this.getMonth()+1,                 //月份 
        "d+" : this.getDate(),                    //日 
        "h+" : this.getHours(),                   //小时 
        "m+" : this.getMinutes(),                 //分 
        "s+" : this.getSeconds(),                 //秒 
        "q+" : Math.floor((this.getMonth()+3)/3), //季度 
        "S"  : this.getMilliseconds()             //毫秒 
    }; 
    if(/(y+)/.test(fmt)) {
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    }
     for(var k in o) {
        if(new RegExp("("+ k +")").test(fmt)){
             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
         }
     }
    return fmt; 
} 

function test(){
  var str="2018-05-29 10:00";
  var d1=new Date(Date.parse(str));
  console.info(d1);
  d1.setTime(d1.setMinutes(d1.getMinutes() + 33));
  console.info(d1);
  var temp=d1.format("yyyy-MM-dd hh:mm");
  alert(temp);
}

</script>
</body>
</html>