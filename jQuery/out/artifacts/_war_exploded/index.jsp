
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>省市级联查询</title>
      <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
      <script type="text/javascript">
        $(function () {


        //    绑定事件
            $("#btnlod").click(function () {
            //    使用jquery做ajax
                $.ajax({
                    url:"provice",
                    dataType:"json",
                    success:function(resp) {
                        //    双击出现重复事件，删除数据
                        $("#province").empty();
                        $.each(resp,function (i,n) {
                        //    获取select 的dom对象
                            $("#province").append("<option id='"+n.id+"'>"+n.name+"</option>")
                        })
                    }
                })
            })
        })

            $("#btnlod").click(function () {
                //给省份的select绑定一个change事件，当select内容发生变化时，触发事件
                $("#province").change(function () {
                    //获取选中的列表框的值
                    var obj = $("#province>option:selected");
                    // alert(" select 的change 事件" + obj.val() + "===="+obj.text())
                    var provinceId = obj.val(); // 1 ,2, 3

            //        做一个ajax请求，获取省份所有城市信息
                    $.post("jquerycity",{proid:provinceId},function (resp){
                        //清空数据
                        $("#city").empty();
                        $.each(resp,function (i,n) {
                            $("#city").append("<option id='"+n.id+"'>"+n.name+"</option>")
                        })
                    },"json" )
            })


        })

      </script>
</head>
<body>
<p>省市级联查询,使用ajax</p>
<div>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                省份：
            </td>
            <td>
                <select id="province">
                    <option value="0">请选择.....</option>
                </select>
                <input type="button" value="load数据" id="btnlod" />
            </td>

        </tr>
        <tr>
            <td>城市：</td>
            <td>
                <select id="city">
                    <option value="0">请选择.....</option>
                </select>
            </td>
        </tr>
    </table>
</div>
</body>
</html>