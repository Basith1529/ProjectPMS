const btnPopup = document.querySelector('.btnLogin-popup');
const cover_box = document.querySelector('.cover_box');
const loginlink = document.querySelector('.login-link');
const registerlink = document.querySelector('.register-link');
const iconClose = document.querySelector('.icon-close');

function activateCoverBox(){
    cover_box.classList.add('active');
}

function deactivateCoverBox(){
    cover_box.classList.remove('active');
}

function activatePopup(){
    cover_box.classList.add('active-popup');
}

function deactivateCoverPopup(){
    cover_box.classList.remove('active-popup');
}

registerlink.addEventListener('click', activateCoverBox);
loginlink.addEventListener('click', deactivateCoverBox);
btnPopup.addEventListener('click', activatePopup);
iconClose.addEventListener('click', deactivateCoverPopup);