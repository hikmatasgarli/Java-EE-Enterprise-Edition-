
function getTeacherListByLessonId(lessonId) {
    $.ajax({
        url: 'cs?action=getTeacherListByLessonId',
        type: 'GET',
        data: 'lessonId='+lessonId,
        dataType: 'html',
        success: function (response) {
            $('#advTeacherCmbId').html(response);

        }
    });
}

function advancedSearchPaymentData() {
    var advLessonCbmId = $('#advLessonCmbId').val();
    var advTeacherCmbId = $('#advTeacherCmbId').val();
    var advMaxAmount = $('#advMaxAmount').val();
    var advMinAmount = $('#advMinAmount').val();
    var advBeginDataId = $('#advBeginDataId').val();
    var advEndDateId = $('#advEndDateId').val();

    var data = {
        advLessonCbmId: advLessonCbmId,
        advTeacherCmbId: advTeacherCmbId,
        advMaxAmount: advMaxAmount,
        advMinAmount: advMinAmount,
        advBeginDataId: advBeginDataId,
        advEndDateId: advEndDateId
    };

    $.ajax({
        url: 'cs?action=advancedSearchPaymentData',
        type: 'GET',
        data: data,
        dataType: 'html',
        success: function (response) {
            $('#paymentDivid').html(response);
        }
    });

}