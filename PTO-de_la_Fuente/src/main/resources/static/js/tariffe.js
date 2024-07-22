const table = document.getElementById('tariffe');
const url = 'http://localhost:8081/tariffe';

fetch(url)
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        let tariffe = data;

        tariffe.map(
            function(tariffa) {
                aggiungi_tabella(
                    `${tariffa.id}`,
                    `${tariffa.nomeCorriere}`,
                    `${tariffa.nomeTariffa}`,
                    `${tariffa.pesoMassimo}`,
                    `${tariffa.costo}`,
                );
            });
    })
    .catch(function(error) {
        console.log(error);
    });

function aggiungi_tabella(
    id_tariffa,
    nome_corriere_tariffa,
    nome_tariffa,
    peso_massimo_tariffa,
    costo_tariffa
){

    let tr = document.createElement('tr');
    let id = document.createElement('td');
    let nomeCorriere = document.createElement('td');
    let nomeTariffa = document.createElement('td');
    let pesoMassimo = document.createElement('td');
    let costo = document.createElement('td');

    id.innerHTML = id_tariffa;
    nomeCorriere.innerHTML = nome_corriere_tariffa;
    nomeTariffa.innerHTML = nome_tariffa;
    pesoMassimo.innerHTML = peso_massimo_tariffa;
    costo.innerHTML = costo_tariffa;

    tr.appendChild(id);
    tr.appendChild(nomeCorriere);
    tr.appendChild(nomeTariffa);
    tr.appendChild(pesoMassimo);
    tr.appendChild(costo);
    table.appendChild(tr);

}