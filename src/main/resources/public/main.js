const TIMEOUT = 5000;

var AddressBooks = {
    setup: function () {
        $('#addBuddyInfo').submit(AddressBooks.addBuddy);
        $(document).on("click", "#addressbookList p a", function () {
            $.ajax({
                type: 'GET',
                url: "/addressbook?id="+$(this).attr("href").split("=").pop(),
                timeout: TIMEOUT,
                success: function (data, requestStatus, xhrObject) {
                    console.log(data);
                    $("#addressBookTable").empty();
                    for (let buddyInfo of data.buddyInfos){

                        $("#addressBookTable").append(`

                        <tr id="${buddyInfo.id}">
                            <td>${buddyInfo.name}</td>
                            <td>${buddyInfo.phoneNumber}</td>
                            <td>${buddyInfo.address}</td>
                        </tr>
            `       );
                    }
                },
                error: function (xhrObj, textStatus, exception) {
                    alert('Error!');
                }

            })
            return false;
        })
        },

    // Adding buddy
    addBuddy: function (event) {
        event.preventDefault();
        let addressBookId = $('#bookId').val();
        let name = $('#name').val();
        let address = $('#address').val();
        let phoneNumber = $('#phoneNumber').val();
        let url = "/addressbook/buddy?bookId=" + addressBookId;
        $.ajax({
            type: 'POST',
            url: url,
            timeout: TIMEOUT,
            datatype: 'json',
            contentType: 'application/json',
            data: JSON.stringify({"name": name, "phoneNumber": phoneNumber, "address": address}),
            success:
                function (data, requestStatus, xhrObject) {
                    $("#addressBookTable").append(`
                        <tr id=${data.id}>
                            <td>${data.name}</td>
                            <td>${data.phoneNumber}</td>
                            <td>${data.address}</td>
                        </tr>
            `)},
            error: function (xhrObj, textStatus, exception) {
                alert('Error!');
            }
            // 'success' and 'error' functions will be passed 3 args
        }).then(function (data) {
            console.log(data);
        });
        return (false);
    },

    addAddressbook: function (event) {
        $.ajax({
            type: 'POST',
            url: "/addressbook",
            timeout: TIMEOUT,
            success: function (data, requestStatus, xhrObject) {
                $("#addressbookList").append(
                    `<p><a href="/addressbook?id=${data.id}">AddressBook ${data.id}</a></p>`
                );
            },
            error: function (xhrObj, textStatus, exception) {
                alert('Error!');
            }
        }).then(function (data) {
            console.log(data);
        });
        return false;
    },

    // getAddressbook: function () {
    //
    // }
}

$(AddressBooks.setup);
