$(function () {

    $('#paymentDataBtnId').click(function () {
        getPaymentList();
    });


    $('#newPaymentDialogId').dialog({
        title: 'Add New Payment',
        height: 300,
        width: 300,
        autoOpen: false,
        buttons: {
            "Save": function () {
                addPayment();
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });
    $('#editPaymentDialogId').dialog({
        title: 'Edit Payment',
        height: 400,
        width: 400,
        autoOpen: false,
        modal: true, //Qiraqdan hecne mudaxile  olmur
        buttons: {
            "Update": function () {
                updatePayment();

            },
            "Close": function () {
                $(this).dialog('close');
            }

        }
    });
});


function getPaymentList() {
    $.ajax({
        url: 'gt?action=getPaymentList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.main').html(response);
            $('.sidebar2').hide();
            $('.main').css({"width": "80%"});
        },
        error: function () {
            alert('Error');
        }
    });
}

function addPayment() {
    var studentId = $('#studentCmbId').val();
    var teacherId = $('#teacherCmbId').val();
    var lessonId = $('#lessonCmbId').val();
    var amountId = $('#amountId').val();

    var data = {
        studentId: studentId,
        teacherId: teacherId,
        lessonId: lessonId,
        amountId: amountId
    };

    $.ajax({
        url: 'ad?action=addPayment',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert('Payment has been successfully added!');
                getPaymentList();
                $('#newPaymentDialogId').dialog('close');
            } else {
                alert('Problem Payment has not been successfully added!')
            }
        }
    });
}
function updatePayment() {
    var studentId = $('#studentCmbIdU').val();
    var teacherId = $('#teacherCmbIdU').val();
    var lessonId = $('#lessonCmbIdU').val();
    var amountId = $('#amountIdU').val();

    var data = {
        studentId:studentId,
        teacherId:teacherId,
        lessonId:lessonId,
        amountId:amountId,
        paymentId: globpaymentId
    };

    $.ajax({
        url: 'up?action=updatePayment',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert('Payment has been successfully UPDATED!');
                getPaymentList();
                $('#editPaymentDialogId').dialog('close');
            } else {
                alert('Problem Payment has not been successfully UPDATED!')
            }
        }
    });


}

function editPayment(paymentId) {
    globpaymentId = paymentId;
    $.ajax({
        url: 'ed?action=editPayment',
        type: 'GET',
        data: 'paymentId='+paymentId,
        dataType: 'html',
        success: function (response) {
            $('#editPaymentDialogId').html(response);
            $('#editPaymentDialogId').dialog('open');
        }
    });
}

function deletePayment(paymentId,paymenntinadi) {
    var isSure = confirm("Are you sure " + paymenntinadi + " ?");

    if(isSure) {
        $.ajax({
            url: 'dl?action=deletePayment',
            type: 'POST',
            data: 'paymentId='+paymentId,
            dataType: 'text',
            success: function (response) {
             if(response == 'success') {
                 alert('Payment has been successfully deleted!');
                 getPaymentList();
             }  else{
                 alert('Problem! Payment has not been successfully deleted!');
             }
            }
        });
    }
}
