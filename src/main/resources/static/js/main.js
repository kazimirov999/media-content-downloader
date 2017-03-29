/**
 * Created by Kazimirov on 27.03.2017.
 */

(function () {

    function initMediaType() {
        $.get('/media-type/get/all', function (response) {
            var select = $('#media-type');
            select.empty();
            $.each(response, function (key, value) {
                var typeName = value.charAt(0).toUpperCase() + value.slice(1).toLowerCase();
                select.append('<option value="' + value + '">' + typeName + '</option>');
            });
        });
    }

    function importMedia() {
        var data = {};
        data.mediaType = $('#media-type').val();
        data.year = $('#year').val();
        data.title = $('#title').val();
        $.ajax({
            contentType: "application/json; charset=utf-8",
            type: "POST",
            url: "/media-content/import",
            data: JSON.stringify(data),
            success: function (responce) {
                alert(responce);
            },
            error: function (callback) {
                console.log(callback);
            }
        });
    }

    $(document).ready(function () {
        $('#import-media-btn').on("click", function () {
            importMedia();
        });

        initMediaType();
    });

}());

