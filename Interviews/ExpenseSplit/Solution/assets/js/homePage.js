document.addEventListener('DOMContentLoaded', () => {
    init();
});

function init() {
    document.getElementById('login-form').classList.toggle('display');

    let showLogin = document.getElementById('showLogin');
    showLogin.addEventListener('click', toggleForm);

    let showSignIn = document.getElementById('showSignIn');
    showSignIn.addEventListener('click', toggleForm);

    let loginBtn = document.getElementById('loginBtn');
    loginBtn.addEventListener('click', () => {
        let unField = document.getElementById('loginUser');
        dashboard(unField.value);
    });

    let signInBtn = document.getElementById('signInBtn');
    signInBtn.addEventListener('click', () => {
        let unField = document.getElementById('newUser');
        dashboard(unField.value);
    });
}

function toggleForm() {
    document.getElementById('login-form').classList.toggle('display');
    document.getElementById('register-form').classList.toggle('display');
}

function dashboard(username) {
    localStorage.setItem('EXSUser', username);
    window.document.location = './dashboard.html';
}