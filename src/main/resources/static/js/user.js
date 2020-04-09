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

function show(id) {
    $.get(encodeURI("find/"+id),function (res) {
        $("#userForm").populateForm(res)
    })
    $("#userForm").submit(function () {
        var param = $(this).serializeArray()
        var jsonParam = {}
        $.each(param,function (i, field) {
            jsonParam[field.name] = field.value
        })
        console.log(jsonParam.id)
        if(jsonParam.id != null){
            // 判断修改还是新增
            $.post("update",param,function (res) {
                if (res){
                    alert("操作成功")
                    $("#myModal").modal("hide")
                    window.location.reload()
                }else{
                    alert("操作失败...")
                }
            })
        }else{
            alert("add")
        }
        return false;
    })
}
function del(id) {
    if( window.confirm("确定删除？") ){
        $.post(encodeURI("delete/"+id),function (res) {
            if (res){
                alert("操作成功")
                $("#myModal").modal("hide")
                window.location.reload()
            }else{
                alert("操作失败...")
            }
        })
    }
}
