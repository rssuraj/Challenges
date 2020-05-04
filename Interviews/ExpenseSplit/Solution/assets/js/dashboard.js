document.addEventListener('DOMContentLoaded', () => {
    init();
});

function init() {
    let userSpan = document.getElementById('user');
    userSpan.textContent = localStorage.getItem('EXSUser');
}