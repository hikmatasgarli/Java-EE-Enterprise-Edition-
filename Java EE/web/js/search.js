$(function () {
    $('#searchBtnId').click(function () {
        simpleSearch();
    });

    $('#keywordId').keyup(function () {
        simpleSearch();
    });


});

function simpleSearch() {
    var keyword = $('#keywordId').val();

    switch (globBtnId) {
        case 'studentDataBtnId':
            searchStudentData(keyword);
            break;
        case 'teacherDataBtnId':

            break;
        case 'paymentDataBtnId':
        searchPaymentData(keyword);
            break;
        case 'lessonDataBtnId':

            break;

        default:
            alert('Select Menu!');
    }
}

function searchStudentData(keyword) {
    $.ajax({
        url: 'cs?action=searchStudentData',
        type: 'GET',
        data: 'keyword='+keyword,
        dataType: 'html',
        success: function (response) {
            $('.main').html(response);
        }
    });
}

function searchPaymentData(keyword) {

}