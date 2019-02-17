/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    function inserer(input, str) {
        if(typeof input==="string") { 
            input = document.getElementById(input); 
       }
       input.value = str;
   }

