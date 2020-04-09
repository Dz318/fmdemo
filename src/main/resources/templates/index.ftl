<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ftl</title>
    <#include "common.ftl">
</head>
<body>
<br/>
<button type="button" class="btn btn-primary" onclick="openAddDialog()">新增</button>
<br/>
<div>
    <table class="table table-responsive">
        <caption>用户信息表</caption>
        <tr>
            <th>姓名</th>
            <th>年龄</th>
            <th>城市</th>
            <th>地址</th>
            <th>OP</th>
        </tr>
        <#if users ??>
            <#list users as user>
                <tr>
                    <td>${user.userName}</td>
                    <td>${user.age}</td>
                    <td>${user.city}</td>
                    <td>${user.address}</td>
                    <td><button type="button" class="btn btn-primary"
                                data-toggle="modal" data-target="#myModal"
                                onclick="show(${user.id})">查看</button>
                        <button type="button" class="btn btn-danger" onclick="del(${user.id})">删除</button>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="padding: 30px">
            <form class="form-horizontal" role="form" id = "userForm">
                <div class="form-group">
                    <label for="firstname" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="hidden" class="form-control" name="id">
                        <input type="text" class="form-control" name="userName" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-2 control-label">年龄</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" name="age" placeholder="请输入年龄">
                    </div>
                </div>
                <div class="form-group">
                    <label for="city" class="col-sm-2 control-label">城市</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="city">
                            <option value="北京">北京</option>
                            <option value="上海">上海</option>
                            <option value="广州">广州</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-2 control-label">地址</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="address" placeholder="请输入姓">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">确认</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
