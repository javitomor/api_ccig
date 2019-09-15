function cargarMenu(menu){
  if (menu=="home") {
    $(#divMenu).load("/templates/ccig/mm/home.html");
  }else if (menu=="ccig") {
    $(#divMenu).load("/templates/ccig/mm/cagarMm.html");
  }
  
}
