// JSON数据赋值表单
$.fn.populateForm = function(data){
    return this.each(function(){
        var formElem, name;
        if(data == null){this.reset(); return; }
        for(var i = 0; i < this.length; i++){
            formElem = this.elements[i];
            //checkbox的name可能是name[]数组形式
            name = (formElem.type === "checkbox")? formElem.name.replace(/(.+)\[\]$/, "$1") : formElem.name;
            if(data[name] === undefined) continue;
            switch(formElem.type){
                case "checkbox":
                    if(data[name] === ""){
                        formElem.checked = false;
                    }else{
                        //数组查找元素
                        if(data[name].indexOf(formElem.value) > -1){
                            formElem.checked = true;
                        }else{
                            formElem.checked = false;
                        }
                    }
                    break;
                case "radio":
                    if(data[name] === ""){
                        formElem.checked = false;
                    }else if(formElem.value === data[name]){
                        formElem.checked = true;
                    }
                    break;
                case "button": break;
                default: formElem.value = data[name];
            }
        }
    });
};

function openAddDialog() {
    $("#userForm").find('input,input[type=hidden]').each(function() {
          $(this).val('');
    });
    $("#myModal").modal("show")
}

$(function () {
    $("#userForm").submit(function () {
        var param = $(this).serializeArray()
        var jsonParam = {}
        $.each(param,function (i, field) {
            jsonParam[field.name] = field.value
        })
        var rtype
        if(jsonParam.id != null && jsonParam.id !== ''){
            rtype = "POST"
        }else{
            rtype = "PUT"
        }
        // 判断修改还是新增
        $.ajax({
            url:"/user/",
            type:rtype,
            data:JSON.stringify(jsonParam),
            contentType: "application/json",
            dataType:"json",
            success:function (res) {
                if (res){
                    alert("操作成功")
                    $("#myModal").modal("hide")
                    window.location.reload()
                }else{
                    alert("操作失败...")
                }
            }
        })
        return false;
    })
})
function show(id) {
    $.get(encodeURI("/user/"+id),function (res) {
        $("#userForm").populateForm(res)
    })
}
function del(id) {
    if(window.confirm("确定删除吗？") ){
        $.ajax({
            url:'/user/'+id,
            type:"delete",
            contentType: "application/json",
            dataType:'json',
            success: function (res) {
                if (res){
                    alert("操作成功")
                    $("#myModal").modal("hide")
                    window.location.reload()
                }else{
                    alert("操作失败...")
                }
            }
        })
    }
}
