/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
console.log('dentro correcto');

document.querySelector('#boton1').addEventListener('click',limpiar);
document.querySelector('#boton').addEventListener('click', traerDatos);
function traerDatos() {
    
    /*
     * todo lo siguiente es AJAX
     * https://www.youtube.com/watch?v=M4LaQ3KUGOM
     * */
    const xhttp = new XMLHttpRequest();
    xhttp.open('GET', 'json/catalogo.json', true);
    xhttp.send();
    xhttp.onreadystatechange = function () {

        if (this.readyState === 4 && this.status === 200) {
            let res = document.querySelector('#res');
            res.innerHTML = '';
            let datos = JSON.parse(this.responseText);
            for (let items of datos) {
                res.innerHTML += `
                <tr>
                <td> ${items.titulo} </td>
                <td> ${items.artista} </td>
                </tr>
                `;
            }
            
        }

    };
}

function limpiar() {
    let res = document.querySelector('#res');
    res.innerHTML = '';
}
