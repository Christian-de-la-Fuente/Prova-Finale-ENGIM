const table = document.getElementById('ordini');
const url = 'http://localhost:8081/ordini';

fetch(url)
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        let ordini = data;

        ordini.map(
            function(ordine) {
                aggiungi_tabella(
                    `${ordine.id}`,
                    `${ordine.nome}`,
                    `${ordine.nomeDitta}`,
                    `${ordine.nomePiano}`,
                    `${ordine.prezzo}`
                );
            });
    })
    .catch(function(error) {
        console.log(error);
    });

function aggiungi_tabella(id_ordine,numero_ordine,data_ordine,costo_tariffa,nome_corriere_tariffa,nome_tariffa){

    let tr = document.createElement('tr');
    let id = document.createElement('td');
    let numero = document.createElement('td');
    let data = document.createElement('td');
    let costo = document.createElement('td');
    let nomeCorriere = document.createElement('td');
    let nomeTariffa = document.createElement('td');

    id.innerHTML = id_ordine;
    numero.innerHTML = numero_ordine;
    data.innerHTML = data_ordine;
    costo.innerHTML = costo_tariffa;
    nomeCorriere.innerHTML = nome_corriere_tariffa;
    nomeTariffa.innerHTML = nome_tariffa;

    tr.appendChild(id);
    tr.appendChild(numero);
    tr.appendChild(data);
    tr.appendChild(costo);
    tr.appendChild(nomeCorriere);
    tr.appendChild(nomeTariffa);
    table.appendChild(tr);

}