module Relogio(
  input logic clk, // Sinal de clock
  output logic [3:0] horas, // Saída para as horas (0-23)
  output logic [5:0] minutos, // Saída para os minutos (0-59)
  output logic [5:0] segundos // Saída para os segundos (0-59)
);

  // Variáveis para manter o estado do relógio
  logic [3:0] horas_reg = 4'b0000;
  logic [5:0] minutos_reg = 6'b000000;
  logic [5:0] segundos_reg = 6'b000000;

  always_ff @(posedge clk) begin
    // Incrementa os segundos a cada pulso de clock
    segundos_reg <= segundos_reg + 1;

    // Verifica se os segundos alcançaram 60, então reinicia e incrementa os minutos
    if (segundos_reg == 6'b111100) begin
      segundos_reg <= 6'b000000;
      minutos_reg <= minutos_reg + 1;

      // Verifica se os minutos alcançaram 60, então reinicia e incrementa as horas
      if (minutos_reg == 6'b111100) begin
        minutos_reg <= 6'b000000;
        horas_reg <= horas_reg + 1;

        // Verifica se as horas alcançaram 24, então reinicia
        if (horas_reg == 4'b1001) begin
          horas_reg <= 4'b0000;
        end
      end
    end
  end

  assign horas = horas_reg;
  assign minutos = minutos_reg;
  assign segundos = segundos_reg;

endmodule
