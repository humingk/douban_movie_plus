<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: humin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <style>
        body {
            background-color: black;
            color: white;
        }
    </style>
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>豆瓣电影1S</title>
    <script type="text/javascript">

        // ajax search 智能提醒----------------------------- start

        var xmlhttp;

        // 异步获取用户输入的信息
        function getMoreNames() {
            var name = document.getElementById("search_name");
            if(name.value == ""){
                clearName();
                return;
            }
            xmlhttp=newAjax();
            // var url="search?name="+escape(name.value);
            var url="searchTips?searchTips_name="+name.value;
            // xmlhttp.responseType='json';
            // true 异步
            xmlhttp.open("GET",url,true);
            // 调用回调方法
            xmlhttp.onreadystatechange=callback;
            xmlhttp.send();
        }

        //通用获取xmlhttp方法
        function newAjax() {
            try { return new XMLHttpRequest();                    } catch(e){}
            try { return new ActiveXObject('Msxml2.XMLHTTP.6.0'); } catch(e){}
            try { return new ActiveXObject('Msxml2.XMLHTTP.3.0'); } catch(e){}
            try { return new ActiveXObject('Msxml2.XMLHTTP');     } catch(e){}
            try { return new ActiveXObject('Microsoft.XMLHTTP');  } catch(e){}
            return false;
        }


        // 回调方法
        function callback() {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                var result= JSON.parse(xmlhttp.responseText);
                showTips(result);
            }
        }

        // 设置tips展示
        function showTips(json) {
            clearName();
            setLocation();
            for (var i = 0; i < json.length ; i++) {

                var tr = document.createElement("tr");
                var tdForName = document.createElement("td");
                var tdForRate = document.createElement("td");

                tdForName.setAttribute("border",0);
                tdForName.setAttribute("size","40");
                tdForName.setAttribute("align","left");

                tdForRate.setAttribute("border",0);
                tdForRate.setAttribute("size","10");
                tdForRate.setAttribute("align","right");

                tdForName.onmouseover=function(){
                    this.className='mouseOver';
                };
                tdForName.onmouseout=function(){
                    this.className='mouseOut';
                };
                tdForName.onmousedown=function(){
                    //鼠标点击关联数据，跳转
                    window.open(url="subject/"+this.children[0].id);
                };
                var show_name = document.createTextNode(json[i]["name"]);
                show_name;
                tdForName.appendChild(show_name);

                var show_rate= document.createTextNode(json[i]["rate"]);
                tdForRate.appendChild(show_rate);

                tr.appendChild(tdForName);
                tr.appendChild(tdForRate);

                // 用于在onmousedowm中获取到当前tdForName所对应的 URL，通过a.id传递movieId
                var a=document.createElement("a");
                a.id=json[i]["movieId"];
                tdForName.appendChild(a);

                document.getElementById("searchTips_table_tbody").appendChild(tr);
            }

        }

        function clearName() {
            var searchTipsTableTbody=document.getElementById("searchTips_table_tbody");
            // 清除 tr
            for (var i =searchTipsTableTbody.childNodes.length-1;i>=0; i--) {
                searchTipsTableTbody.removeChild(searchTipsTableTbody.childNodes[i]);
            }
            document.getElementById("searchTips").style.border="";
        }

        //设置关联内容的位置
        function setLocation(){

            //关联位置显示位置与输入框
            var name = document.getElementById("search_name");
            var width = name.offsetWidth-2;  //input width
            var left = name["offsetLeft"]; //距左边框的距离
            var top = name["offsetTop"]+name.height; //到顶部的距离

            //获得显示数据的div
            var searchTips = document.getElementById("searchTips");
            searchTips.style.border = "white 1px solid";
            searchTips.style.left = left + "px";
            searchTips.style.top = top + "px";
            searchTips.style.width = width + "px";
            document.getElementById("searchTips_table").width = width + "px";
        }

        //失去焦点，清除数据
        function nameLossFocus(){
            clearName();
        }

        //获得焦点，获取数据
        function nameGetFocus(){
            getMoreNames();
        }
        // ajax search 智能提醒----------------------------- end






        // 获取电影列表
        function searchByAlias() {
            var url = "search.jsp";
            $.ajax({
                url: url,
                data: $("#movieSearch").serialize(),
                type: "POST",
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    displaySearchResult(data);
                }
            });
        }



    </script>

</head>
<body>


<%--电影基本情况搜索，ajax 搜索框智能提醒--%>
<form name="search" id="search" method="get" action="/search">
    <table>
        <tr>
            Search
            <td><input id="search_name" name="search_name" type="text" size="50" placeholder="请输入电影名"
                autocomplete="off" onkeyup="getMoreNames()" onblur="nameLossFocus()" onfocus="nameGetFocus()"></td>
            <td><input type="submit" value="search"></td>
        </tr>
    </table>
    <div id="searchTips">
        <table id="searchTips_table" border="0" cellspacing="0" cellpadding="0">
            <tbody id="searchTips_table_tbody">
            <%--searchTips智能提醒的地方--%>
            </tbody>
        </table>
    </div>
</form>

<br/>




</body>
</html>
