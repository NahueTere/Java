public class 7.18 {
    // 7.18

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

    buscar(numero) {
        for (let i = 0; i < this.numeroElementos; i++) {
            if (this.tabla[i] == numero) {
                return i;
            }
        }

        return -1;
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


class Conjunto {
    constructor(tamano = 10) {
        this.lista = new Lista(tamano);
    }

    getNumeroElementos() {
        return this.lista.getNumeroElementos();
    }

    insertar(numero) {
        if (!this.pertenece(numero)) {
            this.lista.insertarFinal(numero);
        }
    }

    get(indice) {
        return this.lista.get(indice);
    }

    eliminar(numero) {
        let posicion = this.lista.buscar(numero);

        if (posicion != -1) {
            this.lista.eliminar(posicion);
        }
    }

    pertenece(numero) {
        return this.lista.buscar(numero) != -1;
    }

    toString() {
        return "{" + this.lista.toString() + "}";
    }


    // 1. INCLUIDO
    static incluido(c1, c2) {
        for (let i = 0; i < c1.getNumeroElementos(); i++) {

            if (!c2.pertenece(c1.get(i))) {
                return false;
            }
        }

        return true;
    }


    // 2. UNION
    static union(c1, c2) {
        let resultado = new Conjunto();

        // Añadimos los elementos de c1
        for (let i = 0; i < c1.getNumeroElementos(); i++) {
            resultado.insertar(c1.get(i));
        }

        // Añadimos los elementos de c2
        for (let i = 0; i < c2.getNumeroElementos(); i++) {
            resultado.insertar(c2.get(i));
        }

        return resultado;
    }


    // 3. INTERSECCION
    static interseccion(c1, c2) {
        let resultado = new Conjunto();

        for (let i = 0; i < c1.getNumeroElementos(); i++) {

            if (c2.pertenece(c1.get(i))) {
                resultado.insertar(c1.get(i));
            }
        }

        return resultado;
    }


    // 4. DIFERENCIA
    static diferencia(c1, c2) {
        let resultado = new Conjunto();

        for (let i = 0; i < c1.getNumeroElementos(); i++) {

            if (!c2.pertenece(c1.get(i))) {
                resultado.insertar(c1.get(i));
            }
        }

        return resultado;
    }
}


// PROGRAMA PRINCIPAL

let c1 = new Conjunto();

c1.insertar(10);
c1.insertar(20);
c1.insertar(30);

let c2 = new Conjunto();

c2.insertar(20);
c2.insertar(30);
c2.insertar(40);
c2.insertar(50);

console.log("Conjunto 1: " + c1.toString());
console.log("Conjunto 2: " + c2.toString());


// INCLUIDO
console.log("¿C1 está incluido en C2?");
console.log(Conjunto.incluido(c1, c2));


// UNION
let union = Conjunto.union(c1, c2);

console.log("Unión: " + union.toString());


// INTERSECCION
let interseccion = Conjunto.interseccion(c1, c2);

console.log("Intersección: " + interseccion.toString());


// DIFERENCIA
let diferencia = Conjunto.diferencia(c1, c2);

console.log("Diferencia C1 - C2: " + diferencia.toString());
}
