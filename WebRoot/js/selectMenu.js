function selectMenu(typeCode, positionId, selectName, selectedId) {
    //创建一个select
    var $select = $("<select name="+selectName+"></select>");
    //在select中添加一个请选择option
    $select.append("$(<option value=''>---请选择---</option>)")
    $("#"+positionId).append($select);
    //ajax请求
    $.post(
        "${pageContext.request.contextPath}/BaseDictAction",
        { dict_type_code:typeCode },
        function(data){
            $.each( data, function(i, json){
                // alert(json['dict_item_name']);
                var $option = $("<option value='"+json['dict_id']+"'>"+json['dict_item_name']+"</option>");
                if(json['dict_id']==selectedId) {
                    $option.attr("selected","selected");
                }
                $select.append($option);
            });
        },
        "json"
    );
}