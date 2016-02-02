$('#loginForm').submit(function (event) {
        event.preventDefault();
        var data = 'username=' + $('#username').val() + '&password=' + $('#password').val();
        console.log("data"+data);
        $.ajax({
            data: data,
            timeout: 1000,
            type: 'POST',
            url: '/login'
 
        }).done(function(data, textStatus, jqXHR) {
            console.log("success");
            window.location.href = "/display";
 
        }).fail(function(jqXHR, textStatus, errorThrown) {
        	console.log("failure");
            $("#error").append('Bad credentials,Try Again!!');
        });
    });

