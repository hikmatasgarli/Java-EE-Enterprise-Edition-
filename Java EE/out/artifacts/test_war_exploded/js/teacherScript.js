$(function () {
    $('#teacherDataBtnId').click(function () {
        getTeacherList();
    });

    $('#newTeacherDialogId').dialog({
        title: 'New Teacher',
        height: 400,
        width: 400,
        autoOpen: false,
        modal: true, //Qiraqdan hecne mudaxile  olmur
        buttons: {
            "Save" : function () {
                addTeacher();

            },
            "Close" : function () {
                $(this).dialog('close');
            }

        }
    });
    $('#editTeacherDialogId').dialog({
        title: 'Update Teacher',
        height: 400,
        width: 400,
        autoOpen: false,
        modal: true, //Qiraqdan hecne mudaxile  olmur
        buttons: {
            "Update": function () {
                updateTeacher();

            },
            "Close": function () {
                $(this).dialog('close');
            }

        }
    });

});

function getTeacherList() {
    $.ajax({
        url: 'gt?action=getTeacherList',
        type: 'GET',
        dataType: 'html', //Serverden qaidan responsdu , xml, json, text qebul ede bilerik
        success: function (response) {
            $('.main').html(response);
            $('.sidebar2').hide();
            $('.main').css({"width":"80%"});
        },
        error: function () {
            alert('Error');
        }

    });
}

function addTeacher() {
    var name = $('#nameIdT').val();
    var surname = $('#surnameIdT').val();
    var address = $('#addressIdT').val();
    var dob = $('#dobIdT').val();
    var phone = $('#phoneIdT').val();
    var  data = {
        'name' : name ,
        'surname' : surname,
        'address': address,
        'dob': dob,
        'phone': phone

    };

    $.ajax({
        url: 'ad?action=addTeacher',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (response) {
            if(response == 'success') {
                alert('Teacher has been successfully added!');
                getTeacherList();
                $('#newTeacherDialogId').dialog('close');
            }else{
                alert('Problem Teacher has not been successfully added!');
            }

        }

    });
}

function editTeacher(teacherId) {
    globTeacherId = teacherId;
    $.ajax({
        url: 'ed?action=editTeacher',
        type: 'GET',
        data: 'teacherId=' + teacherId,
        dataType: 'html',
        success: function (response) {
            $('#editTeacherDialogId').html(response);
            $('#editTeacherDialogId').dialog('open');
        }
    });
}

function updateTeacher() {
    var name = $('#nameIdT').val();
    var surname = $('#surnameIdT').val();
    var address = $('#addressIdT').val();
    var dob = $('#dobIdT').val();
    var phone = $('#phoneIdT').val();
    var data = {
        'name': name,
        'surname': surname,
        'address': address,
        'dob': dob,
        'phone': phone,
        teacherId: globTeacherId
    };

    $.ajax({
        url: 'up?action=updateTeacher',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert('Teacher has been successfully updated!');
                getTeacherList();
                $('#editTeacherDialogId').dialog('close');
            } else {
                alert('Problem Teacher has not been successfully updated!')
            }
        }
    });
}

function deleteTeacher(teacherId, fullname) {
    var isSure = confirm("Are you sure " + fullname + " ?");

    if (isSure) {
        $.ajax({
            url: 'dl?action=deleteTeacher',
            type: 'POST',
            data: 'teacherId=' + teacherId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Teacher has been successfully deleted!');
                    getTeacherList();

                } else {
                    alert('Problem Teacher has not been successfully deleted!')
                }
            }
        });
    }
}