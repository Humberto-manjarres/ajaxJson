/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.querySelector('#boton').addEventListener('click', function () {
    
    var enviarDato = {cod: "valor"};
    console.log('cod--> '+ enviarDato.cod);
    const xhttp = new XMLHttpRequest();
    xhttp.open('GET', 'servletJsonAjax', true);
    xhttp.send(enviarDato);
    xhttp.onreadystatechange = function () {

        if (this.readyState === 4 && this.status === 200) {
            let res = document.querySelector('#res');
            res.innerHTML = '';
            let datos = JSON.parse(this.responseText);

            for (let items of datos) {
                res.innerHTML += `
                <tr>
                <td> ${items.nombre} </td>
                <td> ${items.edad} </td>
                </tr>
                `;
            }

        }

    };

});

document.querySelector('#boton1').addEventListener('click', function () {
    let res = document.querySelector('#res');
    res.innerHTML = '';
});

