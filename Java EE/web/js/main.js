
$(function () {


    $('.test').click(function () {
        test();
    });

});

var globBtnId = '';
var globStudentId = 0;
var globpaymentId = 0;
var globTeacherId = 0;
var globLessonId = 0;
/* Clikler */

$(function () {

    $('.btnDesign').click(function () {
        globBtnId = $(this).attr('id');
    });

    $('#newBtnId').click(function () {
        switch (globBtnId) {
            case 'studentDataBtnId':
                $('#newStudentDialogId').load('views/add/newStudent.jsp', function () {
                    $(this).dialog('open');
                });
                break;
            case 'teacherDataBtnId':
                $('#newTeacherDialogId').load('views/add/newTeacher.jsp', function () {
                    $(this).dialog('open');
                });
                break;
            case 'paymentDataBtnId':
                $('#newPaymentDialogId').load('nw?action=newPayment', function () {
                    $(this).dialog('open');
                });
                break;
            case 'lessonDataBtnId':
                $('#newLessonDialogId').load('views/add/newLesson.jsp', function () {
                    $(this).dialog('open');
                });
                break;

            default:
                alert('Select Menu!');
        }
    });
});

function test() {
  $.ajax({
        success: function () {
            if(success == onclick){
                alert("SUCKA");
            }
        }


  });


}
