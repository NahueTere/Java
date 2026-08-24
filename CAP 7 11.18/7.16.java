public class 7.16 {
    // 7.16

class Lista {
    constructor(tamano = 10) {
        this.tabla = new Array(tamano);
        this.numeroElementos = 0;
    }

    getNumeroElementos() {
        return this.numeroElementos;
    }

    insertarFinal(numero) {
        this.comprobarEspacio();
        this.tabla[this.numeroElementos] = numero;
        this.numeroElementos++;
    }

    eliminar(indice) {
        if (indice < 0 || indice >= this.numeroElementos) {
            return;
        }

        for (let i = indice; i < this.numeroElementos - 1; i++) {
            this.tabla[i] = this.tabla[i + 1];
        }

        this.numeroElementos--;
    }

    get(indice) {
        if (indice < 0 || indice >= this.numeroElementos) {
            return null;
        }

        return this.tabla[indice];
    }

    toString() {
        let texto = "";

        for (let i = 0; i < this.numeroElementos; i++) {
            texto = texto + this.tabla[i];

            if (i < this.numeroElementos - 1) {
                texto = texto + ", ";
            }
        }

        return texto;
    }

    comprobarEspacio() {
        if (this.numeroElementos == this.tabla.length) {
            let nuevaTabla = new Array(this.tabla.length * 2);

            for (let i = 0; i < this.numeroElementos; i++) {
                nuevaTabla[i] = this.tabla[i];
            }

            this.tabla = nuevaTabla;
        }
    }
}


// CLASE COLALISTA

class ColaLista {
    constructor() {
        this.lista = new Lista();
    }

    // Encolar
    encolar(numero) {
        this.lista.insertarFinal(numero);
    }

    // Desencolar
    desencolar() {
        if (this.estaVacia()) {
            return null;
        }

        let numero = this.lista.get(0);

        this.lista.eliminar(0);

        return numero;
    }

    // Obtener el primero
    primero() {
        if (this.estaVacia()) {
            return null;
        }

        return this.lista.get(0);
    }

    // Obtener el último
    ultimo() {
        if (this.estaVacia()) {
            return null;
        }

        let posicion = this.lista.getNumeroElementos() - 1;

        return this.lista.get(posicion);
    }

    // Comprobar si está vacía
    estaVacia() {
        return this.lista.getNumeroElementos() == 0;
    }

    // Mostrar la cola
    toString() {
        return this.lista.toString();
    }
}


// PROGRAMA PRINCIPAL

let cola = new ColaLista();

cola.encolar(10);
cola.encolar(20);
cola.encolar(30);

console.log("Cola: " + cola.toString());

console.log("Primero: " + cola.primero());

console.log("Último: " + cola.ultimo());

console.log("Desencolamos: " + cola.desencolar());

console.log("Cola después de desencolar:");
console.log(cola.toString());

console.log("Primero: " + cola.primero());

console.log("Último: " + cola.ultimo());
}
