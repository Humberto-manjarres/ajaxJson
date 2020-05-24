/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('#boton').click(function () {

        if ($('#userName').val() === '' || $('#userEdad').val() === '') {
            $('#mensaje').text('Diligenciar todos los campos.');
            let res = document.querySelector('#res');
            res.innerHTML = '';
        } else {

            $.ajax({
                url: 'servletJsonAjax',
                data: {
                    userName: $('#userName').val(),
                    userEdad: $('#userEdad').val()
                },
                success: function (responseText) {
                    if (responseText === '' || responseText === null) {
                        console.log('error-->'+responseText);
                    } else {
                        let res = document.querySelector('#res');
                        res.innerHTML = '';
                        let datos = JSON.parse(responseText);
                        for (let items of datos) {
                            res.innerHTML += `
                        <tr>
                        <td> ${items.nombre} </td>
                        <td> ${items.edad} </td>
                        </tr>
                        `;
                        }
                    }
                    $('#userName').val('');
                    $('#userEdad').val('');
                    $('#mensaje').text('');
                }
            });

        }


    });
    $('#boton1').click(function () {
        let res = document.querySelector('#res');
        res.innerHTML = '';
        $('#userName').val('');
        $('#userEdad').val('');
        $('#mensaje').text('');
    });
});