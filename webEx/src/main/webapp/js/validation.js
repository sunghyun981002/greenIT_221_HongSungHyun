

function selectAll(selectAll)  {
  // alert(selectAll.checked);
  const cb = document.getElementsByName('check');
  
  cb.forEach((checkbox) => {
    console.log(checkbox);
    checkbox.checked = selectAll.checked;
  })
}
function checkValue(form){
  

  if(form.check[1].checked &&form.check[2].checked ){
    form.submit();
  }
  else{
    document.body.querySelector(".backMessege").innerHTML ="";
    let p = document.createElement('p');
    p.setAttribute('id' , 'back');
    p.setAttribute('style',"color: red" )
    p.innerHTML += "네이버 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.";
    document.body.querySelector(".backMessege").append(p);
  }
}

function successJoin(form){
  if(form.id.value!==""&&form.pw.value!==""&&form.checkpw.value!==""&&form.name.value!==""&&form.year.value!==""&&form.month.value!==""&&form.day.value!==""&&form.email.value!==""&&form.nation.value!==""&&form.mobile.value!==""){
    form.submit();
  
  }
  else{
    alert("채우지않은 항목이 있는지 확인하고 작성부탁해.")
  }
  console.log(form.id.value);
  console.log(form.pw.value);
  console.log(form.checkpw.value);
  console.log(form.name.value);
  console.log(form.month.value);
  console.log(form.year.value);
  console.log(form.day.value);
  console.log(form.nation.value);
  console.log(form.mobile.value);
  // "alert('반가워!')"
}
