
// 7.12

class Lista {
    constructor(tamano = 10) {
        this.tabla = new Array(tamano);
        this.numeroElementos = 0;
    }

    // Obtener el número de elementos
    getNumeroElementos() {
        return this.numeroElementos;
    }

    // Insertar un número al final
    insertarFinal(numero) {
        this.comprobarEspacio();
        this.tabla[this.numeroElementos] = numero;
        this.numeroElementos++;
    }

    // Insertar un número al principio
    insertarPrincipio(numero) {
        this.comprobarEspacio();

        for (let i = this.numeroElementos; i > 0; i--) {
            this.tabla[i] = this.tabla[i - 1];
        }

        this.tabla[0] = numero;
        this.numeroElementos++;
    }

    // Insertar un número en una posición
    insertar(numero, indice) {
        if (indice < 0 || indice > this.numeroElementos) {
            console.log("Índice incorrecto");
            return;
        }

        this.comprobarEspacio();

        for (let i = this.numeroElementos; i > indice; i--) {
            this.tabla[i] = this.tabla[i - 1];
        }

        this.tabla[indice] = numero;
        this.numeroElementos++;
    }

    // Añadir los elementos de otra lista
    insertarLista(lista) {
        for (let i = 0; i < lista.getNumeroElementos(); i++) {
            this.insertarFinal(lista.get(i));
        }
    }

    // Eliminar un elemento
    eliminar(indice) {
        if (indice < 0 || indice >= this.numeroElementos) {
            console.log("Índice incorrecto");
            return;
        }

        for (let i = indice; i < this.numeroElementos - 1; i++) {
            this.tabla[i] = this.tabla[i + 1];
        }

        this.numeroElementos--;
    }

    // Obtener un elemento
    get(indice) {
        if (indice < 0 || indice >= this.numeroElementos) {
            return null;
        }

        return this.tabla[indice];
    }

    // Buscar un número
    buscar(numero) {
        for (let i = 0; i < this.numeroElementos; i++) {
            if (this.tabla[i] == numero) {
                return i;
            }
        }

        return -1;
    }

    // Representar la lista como texto
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

    // Comprobar si hay espacio
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


// PROGRAMA PRINCIPAL

let lista = new Lista();

lista.insertarFinal(10);
lista.insertarFinal(20);
lista.insertarFinal(30);

console.log("Lista: " + lista.toString());

lista.insertarPrincipio(5);

console.log("Después de insertar al principio:");
console.log(lista.toString());

lista.insertar(15, 2);

console.log("Después de insertar 15 en la posición 2:");
console.log(lista.toString());

console.log("Número de elementos: " + lista.getNumeroElementos());

console.log("Elemento de la posición 2: " + lista.get(2));

console.log("Posición del número 20: " + lista.buscar(20));

lista.eliminar(2);

console.log("Después de eliminar la posición 2:");
console.log(lista.toString());


// Segunda lista

let lista2 = new Lista();

lista2.insertarFinal(100);
lista2.insertarFinal(200);

lista.insertarLista(lista2);

console.log("Después de añadir la segunda lista:");
console.log(lista.toString());