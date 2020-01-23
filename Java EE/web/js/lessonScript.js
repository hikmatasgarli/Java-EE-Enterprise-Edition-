$(function () {

    $('#lessonDataBtnId').click(function () {
        getLessonList();
    });

    $('#newLessonDialogId').dialog({
        title: 'Add new Lesson',
        width: 400,
        height: 280,
        autoOpen: false,
        modal: true,
        buttons: {
            "Save": function () {
                addLesson();
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });
    $('#editLessonDialogId').dialog({
        title: 'Edin Lesson',
        height: 400,
        width: 400,
        autoOpen: false,
        modal: true, //Qiraqdan hecne mudaxile  olmur
        buttons: {
            "Update": function () {
                updateLesson();

            },
            "Close": function () {
                $(this).dialog('close');
            }

        }
    });

});

function getLessonList() {
    $.ajax({
        url: 'gt?action=getLessonList',
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

function addLesson() {
    var lessonname = $('#lessonnameId').val();
    var lessonprice = $('#lessonpriceId').val();
    var lessontime = $('#lessontimeId').val();

    var data = {
        lessonname: lessonname,
        lessonprice: lessonprice,
        lessontime: lessontime
    };

    $.ajax({
        url: 'ad?action=addLesson',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert('Lesson has been successfully added!');
                getLessonList();
                $('#newLessonDialogId').dialog('close');
            } else {
                alert('Problem Lesson has not been successfully added!')
            }
        }
    });
}

function editLesson(lessonId) {
    globLessonId = lessonId;
    $.ajax({
        url: 'ed?action=editLesson',
        type: 'GET',
        data: 'lessonId='+lessonId,
        dataType: 'html',
        success: function (response) {
            $('#editLessonDialogId').html(response);
            $('#editLessonDialogId').dialog('open');
        }
    });
}


function updateLesson() {
    var lessonname = $('#lessonnameIdW').val();
    var lessonprice = $('#lessonpriceIdW').val();
    var lessontime = $('#lessontimeIdW').val();

    var data = {
        lessonname: lessonname,
        lessonprice: lessonprice,
        lessontime: lessontime,

        lessonId: globLessonId
    };

    $.ajax({
        url: 'up?action=updateLesson',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert('Lesson has been successfully updated!');
                getLessonList();
                $('#editLessonDialogId').dialog('close');
            } else {
                alert('Problem Lesson has not been successfully updated!')
            }
        }
    });
}

function deleteLesson(lessonId, fullname) {
    var isSure = confirm("Are you sure " + fullname + " ?");

    if (isSure) {
        $.ajax({
            url: 'dl?action=deleteLesson',
            type: 'POST',
            data: 'lessonId=' + lessonId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Lesson has been successfully deleted!');
                    getLessonList();

                } else {
                    alert('Problem Lesson has not been successfully deleted!')
                }
            }
        });
    }
}
