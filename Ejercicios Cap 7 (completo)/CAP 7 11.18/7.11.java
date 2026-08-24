
// 7.11

class Hora {
    constructor() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    getHora() {
        return this.hora;
    }

    setHora(hora) {
        this.hora = hora;
    }

    getMinuto() {
        return this.minuto;
    }

    setMinuto(minuto) {
        this.minuto = minuto;
    }

    getSegundo() {
        return this.segundo;
    }

    setSegundo(segundo) {
        this.segundo = segundo;
    }

    siguienteSegundo() {
        this.segundo++;

        if (this.segundo == 60) {
            this.segundo = 0;
            this.minuto++;

            if (this.minuto == 60) {
                this.minuto = 0;
                this.hora++;

                if (this.hora == 24) {
                    this.hora = 0;
                }
            }
        }
    }

    mostrar() {
        console.log(this.hora + ":" + this.minuto + ":" + this.segundo);
    }
}

let h = new Hora();

let hora = parseInt(prompt("Introduce la hora:"));
let minuto = parseInt(prompt("Introduce los minutos:"));
let segundo = parseInt(prompt("Introduce los segundos:"));
let n = parseInt(prompt("Introduce n:"));

h.setHora(hora);
h.setMinuto(minuto);
h.setSegundo(segundo);

console.log("Hora introducida:");
h.mostrar();

for (let i = 0; i < n; i++) {
    h.siguienteSegundo();
    h.mostrar();
}