
$(function () {

    $('#studentDataBtnId').click(function () {
        getStudentList();
    });

    $('#newStudentDialogId').dialog({
        title: 'Add new Student',
        height: 400,
        width: 400,
        autoOpen: false,
        modal: true, //Qiraqdan hecne mudaxile  olmur
        buttons: {
            "Save": function () {
                addStudent();

            },
            "Close": function () {
                $(this).dialog('close');
            }

        }
    });

    $('#editStudentDialogId').dialog({
        title: 'Update Student',
        height: 400,
        width: 400,
        autoOpen: false,
        modal: true, //Qiraqdan hecne mudaxile  olmur
        buttons: {
            "Update": function () {
                updateStudent();

            },
            "Close": function () {
                $(this).dialog('close');
            }

        }
    });

});

function getStudentList() {
    $.ajax({
        url: 'gt?action=getStudentList',
        type: 'GET',
        dataType: 'html',
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


function addStudent() {
    var name = $('#nameId').val();
    var surname = $('#surnameId').val();
    var address = $('#addressId').val();
    var dob = $('#dobId').val();
    var phone = $('#phoneId').val();
    var  data = {
        'name' : name ,
        'surname' : surname,
        'address': address,
        'dob': dob,
        'phone': phone

    };

    $.ajax({
        url: 'ad?action=addStudent',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (response) {
            if(response == 'success') {
                alert('Student has been successfully added!');
                getStudentList();
                $('#newStudentDialogId').dialog('close');
            }else{
                alert('Problem Student has not been successfully added!');
            }

        }

    });
}

function editStudent(studentId) {

    globStudentId = studentId;
    $.ajax({
        url: 'ed?action=editStudent',
        type: 'GET',
        data: 'studentId=' + studentId,
        dataType: 'html',
        success: function (response) {
            $('#editStudentDialogId').html(response);
            $('#editStudentDialogId').dialog('open');
        }
    });
}


function updateStudent() {
    var name = $('#nameIdU').val();
    var surname = $('#surnameIdU').val();
    var address = $('#addressIdU').val();
    var dob = $('#dobIdU').val();
    var phone = $('#phoneIdU').val();
    var data = {
        'name': name,
        'surname': surname,
        'address': address,
        'dob': dob,
        'phone': phone,
        studentId: globStudentId
    };

    $.ajax({
        url: 'up?action=updateStudent',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert('Student has been successfully updated!');
                getStudentList();
                $('#editStudentDialogId').dialog('close');
            } else {
                alert('Problem Student has not been successfully updated!')
            }
        }
    });
}

function deleteStudent(studentId, fullname) {
    var isSure = confirm("Are you sure " + fullname + " ?");

    if (isSure) {
        $.ajax({
            url: 'dl?action=deleteStudent',
            type: 'POST',
            data: 'studentId=' + studentId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Student has been successfully deleted!');
                    getStudentList();

                } else {
                    alert('Problem Student has not been successfully deleted!')
                }
            }
        });
    }
}

