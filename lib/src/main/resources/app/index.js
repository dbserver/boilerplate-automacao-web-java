const inicializarEstadoApp = () => {
  localStorage.setItem("estadoApp", JSON.stringify({
    usuarios: [
      { usuario: "John", senha: "123456" },
      { usuario: "Jane", senha: "asdf" },
    ],
  }));
};

inicializarEstadoApp();

const fazerLogin = () => {
  const usuarioInput = document.getElementById("usuario").value;
  const senhaInput = document.getElementById("senha").value;

  login(usuarioInput, senhaInput);
};

const login = (usuario, senha) => {
  const estadoApp = JSON.parse(localStorage.getItem("estadoApp"));

  const usuarioEncontrado = estadoApp.usuarios.find((u) =>
    u.usuario.toLowerCase() === usuario.toLowerCase()
    && u.senha.toLowerCase() === senha.toLowerCase()
  );

  if (usuarioEncontrado) {
    alert("Usuário conectado com sucesso");
  } else {
    alert("Usuário não encontrado");
  }
};
