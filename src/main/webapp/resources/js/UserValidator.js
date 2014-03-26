
$(document).ready(function() {



    $('form').each(function() {


        // $('#userForm').validate({
        $(this).validate({
            rules: {
                jcaptcha: {required: true
                },
                name: {required: true},
                surname: {required: true}



            },
            messages: {
                name: "Please enter your  name.",
                surname: "Please enter your surname.",
                jcaptcha: {required: "Please enter captcha"}

            },
            errorContainer: $('#errorMessage'),
            errorLabelContainer: $('#errorMessage ul'),
            wrapper: 'li'
        });


    });










});

function refreshCaptcha()
{
    $("#jcapthcaimg").fadeOut(500, function() {

        var captchaURL = $("#jcapthcaimg").attr("src");


        captchaURL = captchaURL + "#" + Math.floor(Math.random() * 9999999999);

        jQuery("#jcapthcaimg").attr('src', captchaURL);
    });
    $("#jcapthcaimg").fadeIn(300);
}


function validateUser() {



    var json = {"jcaptcha": $('#jcaptcha').val()};
    var isValid = false;
    $.ajax({
        url: "user/validate",
        type: 'POST',
        async: false,
        dataType: 'text',
        data: json,
        success: function(data) {

            if (data == "false") {


                isValid = false;


            }
            else if (data == "true") {
                isValid = true;


            }
            else {
                alert("netruenefalse: " + data);
            }

        },
        error: function(data, status, er) {
            alert("failed- " + data + " - " + status + " - " + er);
            isValid = false;

        }
    });

    if (!isValid) {
        alert("Please enter the valid captcha value");
        refreshCaptcha();
    }

    return isValid;

}




