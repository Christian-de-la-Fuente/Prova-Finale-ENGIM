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
    let deleteCell = document.createElement('td'); // Cella per il pulsante di cancellazione

    id.innerHTML = id_tariffa;
    nomeCorriere.innerHTML = nome_corriere_tariffa;
    nomeTariffa.innerHTML = nome_tariffa;
    pesoMassimo.innerHTML = peso_massimo_tariffa;
    costo.innerHTML = `€${costo_tariffa}`;

    let deleteButton = document.createElement('button');
    deleteButton.innerHTML = 'Elimina';
    deleteButton.onclick = function() {
        tr.remove();
    };

    deleteCell.appendChild(deleteButton);

    tr.appendChild(id);
    tr.appendChild(nomeCorriere);
    tr.appendChild(nomeTariffa);
    tr.appendChild(pesoMassimo);
    tr.appendChild(costo);
    tr.appendChild(deleteCell); // Aggiungi la cella del pulsante di cancellazione alla riga
    table.appendChild(tr);

}

function aggiungi() {
    // Ottieni i valori dagli input
    const nomeCorriere = document.getElementById("inputNomeCorriere").value.trim();
    const nomeTariffa = document.getElementById("inputNomeTariffa").value.trim();
    const pesoMassimo = parseFloat(document.getElementById("inputPesoMassimo").value);
    const costo = parseFloat(document.getElementById("inputCosto").value);

    // Validazione degli input
    if (!nomeCorriere || !nomeTariffa) {
        alert("I nomi del corriere e della tariffa devono essere inseriti.");
        return;
    }

    if (isNaN(pesoMassimo) || pesoMassimo <= 0) {
        alert("Il peso massimo deve essere un numero maggiore di zero.");
        return;
    }

    if (isNaN(costo) || costo < 0) {
        alert("Il costo deve essere un numero maggiore o uguale a zero.");
        return;
    }

    // Calcola il nuovo ID
    const ultimoId = calcolaUltimoId();
    const nuovoId = ultimoId + 1;

    // Aggiungi la tariffa con l'ID calcolato
    aggiungi_tabella(nuovoId, nomeCorriere, nomeTariffa, pesoMassimo, costo);
}

function calcolaUltimoId() {
    const righe = table.getElementsByTagName('tr');
    let ultimoId = 0;

    for (let i = 1; i < righe.length; i++) { // Inizia da 1 per saltare l'intestazione
        const idCell = righe[i].getElementsByTagName('td')[0]; // Ottieni la cella ID
        if (idCell) {
            const idVal = parseInt(idCell.innerHTML);
            if (idVal > ultimoId) {
                ultimoId = idVal; // Aggiorna l'ultimo ID se trovato un ID maggiore
            }
        }
    }
    return ultimoId;
}