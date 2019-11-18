var table = document.getElementById('Table'); // ���ﳵ���

   var checkInpus = document.getElementsByClassName('check'); // ���й�ѡ��

   var checkAllInputs = document.getElementsByClassName('check-all') // ȫѡ��

   var tr = table.children[1].rows; //��

   var selectedTotal = document.getElementById('selectedTotal'); //��ѡ��Ʒ��Ŀ����

   var priceTotal = document.getElementById('priceTotal'); //�ܼ�

   var selected=document.getElementById('selected');

   var foot = document.getElementById('foot');

   var selectedViewList = document.getElementById('selectedViewList'); //������ѡ��Ʒ�б�����

   var deleteAll = document.getElementById('deleteAll'); // ɾ��ȫ����ť

   var closing=document.querySelector('.closing');





//����

function getTotal() {

    var selected = 0, price = 0, html = '';

    var HTMLstr=''// ��һ���յ��ַ�����Ȼ�����ƴ��

    for (var i = 0; i < tr.length; i++) {

        if (tr[i].getElementsByTagName('input')[0].checked) {

            tr[i].className='on'

            selected += parseInt(tr[i].getElementsByTagName('input')[1].value); //������ѡ��Ʒ��Ŀ

            price += parseFloat(tr[i].getElementsByTagName('td')[4].innerHTML); //�����ܼƼ۸�

            HTMLstr+= '<div><img src="'+tr[i].getElementsByTagName('img')[0].src+'"><span class="del" index="'+i+'">ȡ��ѡ��</span></div>'

            

        }

        else{

            tr[i].className=''

        }

    }

    selectedTotal.innerHTML = selected; // ��ѡ��Ŀ

    priceTotal.innerHTML = price.toFixed(2); // �ܼ�

    selectedViewList.innerHTML=HTMLstr;



    if(selected==0){

        foot.className='foot'

    }

}

//С��.�㵥�м۸�

function getSubTotal(tr){

    var tds=tr.cells;



    var price=parseFloat(tds[2].innerHTML);

    var count=parseInt(tr.getElementsByTagName('input')[1].value);// ��Ŀinput

    var SubTotal=parseFloat(price*count)

    tds[4].innerHTML=SubTotal.toFixed(2)

}





    // ���ѡ���

    for(var i = 0; i < checkInpus.length; i++ ){

        checkInpus[i].onclick = function () {    

            if(this.className==='check-all check'){ //�����ȫѡ��������е�ѡ���ѡ��

                for(var j=0;j<checkInpus.length;j++){

                    checkInpus[j].checked=this.checked

                    // getTotal();//ѡ������ܼ�

                }

            }

            

            if(this.checked==false){ //ֻҪ��һ��δ��ѡ����ȡ��ȫѡ���ѡ��״̬

                for(var k=0;k<checkAllInputs.length;k++){

                    checkAllInputs[k].checked=false;

                }

            }   

            getTotal();//ѡ������ܼ�

        }

    }



    selected.onclick=function(){

        if(foot.className=='foot'){

            if(selectedTotal.innerHTML!=0){

                foot.className='foot show'

            }

           

        }else{

            foot.className='foot'

        }

    }

    //��ѡ��Ʒ�����е�ȡ��ѡ��ť

    selectedViewList.onclick = function (e) {

        // var e = e || window.event;

        var el = e.srcElement;

        if (el.className=='del') {

            var input =  tr[el.getAttribute('index')].getElementsByTagName('input')[0]

            input.checked = false;

            input.onclick()

        }

    }



    for(var i=0;i<tr.length;i++){

        tr[i].onclick=function(e){

            var el=e.target;

            var cls=el.className;//ͨ���¼������target���Ի�ȡ����Ԫ��

            var input=this.getElementsByTagName('input')[1];// ��Ŀinput

            var val=parseInt(input.value) //��Ŀ

            //ͨ���жϴ���Ԫ�ص�classȷ���û�������ĸ�Ԫ��

            var reduce=this.getElementsByTagName('span')[1];

            switch(cls){

               

                case 'add'://����˼Ӻ�

                input.value=val+1

                reduce.innerHTML='-'

                getSubTotal(this);

                getTotal();

                break;

                case 'reduce': //����˼���

                if(val>1){

                    input.value=val-1

                }

               if(input.value<=1){

                reduce.innerHTML=''

               }

               getSubTotal(this);

               getTotal();

                break;

               

                case 'delete':

                var conf=confirm('ȷ��Ҫɾ����')

                if(conf){

                    this.parentNode.removeChild(this);



                }

                break;

                default:

                break

                

            }



        }

        tr[i].getElementsByTagName('input')[1].onkeyup=function(){

            var val=parseInt(this.value);

            var tr=this.parentNode.parentNode

            var reduce=tr.getElementsByTagName('span')[1];

            if(isNaN(val)||val<1){

                val=1   

            }

            this.value=1;

            if (val<=1){

                reduce.innerHTML=''

            }else{

                reduce.innerHTML='-'

            }



            

            getSubTotal(this.parentNode.parentNode);//input�ĸ��ڵ����td  td�ĸ��ڵ����tr

        }



    }

    // ���ȫ��ɾ��

    deleteAll.onclick = function () {

        if (selectedTotal.innerHTML != 0) {

            var con = confirm('ȷ��ɾ����ѡ��Ʒ��'); //����ȷ�Ͽ�

            if (con) {

                for (var i = 0; i < tr.length; i++) {

                    // �����ѡ�У���ɾ����Ӧ����

                    if (tr[i].getElementsByTagName('input')[0].checked) {

                        tr[i].parentNode.removeChild(tr[i]); // ɾ����Ӧ�ڵ�

                        i--; //�����±�λ��

                    }

                }

            }

        } else {

            alert('��ѡ����Ʒ��');

        }

        getTotal(); //��������

    }



    closing.onclick=function(){

        alert('��򿪸�����֧����'+priceTotal.innerHTML+'$')

    }