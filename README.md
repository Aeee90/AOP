# After Reading The Art Of Computer Programming 
- 내 마음대로 책 정리

## MIX
- 출처: https://en.wikipedia.org/wiki/MIX

1. 하드웨어 구조
- UByte 단위로 구현.
- 부호는 각각 +는 1, -는 0으로 구현.
- 실제 하드웨어 그림: 
<table class="infobox" style="font-size:88%;">
<tbody><tr>
<td align="center"><i>MIX registers</i>
</td></tr>
<tr>
<td>
<table style="font-size:88%;">

<tbody><tr>
<td style="width:10px; text-align:left"><sup>3</sup><sub>0</sub>
</td>
<td style="width:10px; text-align:right"><sup>2</sup><sub>9</sub>
</td>
<td style="width:10px; text-align:right"><sup>2</sup><sub>8</sub>
</td>
<td style="width:10px; text-align:right"><sup>2</sup><sub>7</sub>
</td>
<td style="width:10px; text-align:right"><sup>2</sup><sub>6</sub>
</td>
<td style="width:10px; text-align:right"><sup>2</sup><sub>5</sub>
</td>
<td style="width:10px; text-align:right"><sup>2</sup><sub>4</sub>
</td>
<td style="width:10px; text-align:right"><sup>2</sup><sub>3</sub>
</td>
<td style="width:10px; text-align:right"><sup>2</sup><sub>2</sub>
</td>
<td style="width:10px; text-align:right"><sup>2</sup><sub>1</sub>
</td>
<td style="width:10px; text-align:right"><sup>2</sup><sub>0</sub>
</td>
<td style="width:10px; text-align:right"><sup>1</sup><sub>9</sub>
</td>
<td style="width:10px; text-align:right"><sup>1</sup><sub>8</sub>
</td>
<td style="width:10px; text-align:right"><sup>1</sup><sub>7</sub>
</td>
<td style="width:10px; text-align:right"><sup>1</sup><sub>6</sub>
</td>
<td style="width:10px; text-align:right"><sup>1</sup><sub>5</sub>
</td>
<td style="width:10px; text-align:right"><sup>1</sup><sub>4</sub>
</td>
<td style="width:10px; text-align:right"><sup>1</sup><sub>3</sub>
</td>
<td style="width:10px; text-align:right"><sup>1</sup><sub>2</sub>
</td>
<td style="width:10px; text-align:right"><sup>1</sup><sub>1</sub>
</td>
<td style="width:10px; text-align:right"><sup>1</sup><sub>0</sub>
</td>
<td style="width:10px; text-align:center"><sup>0</sup><sub>9</sub>
</td>
<td style="width:10px; text-align:center"><sup>0</sup><sub>8</sub>
</td>
<td style="width:10px; text-align:center"><sup>0</sup><sub>7</sub>
</td>
<td style="width:10px; text-align:center"><sup>0</sup><sub>6</sub>
</td>
<td style="width:10px; text-align:center"><sup>0</sup><sub>5</sub>
</td>
<td style="width:10px; text-align:center"><sup>0</sup><sub>4</sub>
</td>
<td style="width:10px; text-align:center"><sup>0</sup><sub>3</sub>
</td>
<td style="width:10px; text-align:center"><sup>0</sup><sub>2</sub>
</td>
<td style="width:10px; text-align:center"><sup>0</sup><sub>1</sub>
</td>
<td style="width:10px; text-align:center"><sup>0</sup><sub>0</sub>
</td>
<td style="width:auto; background:white; color:black"><i>(bit position)</i>
</td></tr>
<tr>
<td colspan="32"><b>Registers</b>
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td colspan="1">±
</td>
<td colspan="6">A1
</td>
<td colspan="6">A2
</td>
<td colspan="6">A3
</td>
<td colspan="6">A4
</td>
<td colspan="6">A5
</td>
<td style="text-align:left;background:white"><b>rA</b>, Accumulator
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td colspan="1">±
</td>
<td colspan="6">X1
</td>
<td colspan="6">X2
</td>
<td colspan="6">X3
</td>
<td colspan="6">X4
</td>
<td colspan="6">X5
</td>
<td style="text-align:left;background:white"><b>rX</b>, Extension
</td></tr>
<tr>
<td colspan="32"><b>Index registers</b>
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td style="background:white" colspan="18">&#160;
</td>
<td colspan="1">±
</td>
<td colspan="6">I1.4
</td>
<td colspan="6">I1.5
</td>
<td style="text-align:left;background:white"><b>rI1</b>, Index 1
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td style="background:white" colspan="18">&#160;
</td>
<td colspan="1">±
</td>
<td colspan="6">I2.4
</td>
<td colspan="6">I2.5
</td>
<td style="text-align:left;background:white"><b>rI2</b>, Index 2
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td style="background:white" colspan="18">&#160;
</td>
<td colspan="1">±
</td>
<td colspan="6">I3.4
</td>
<td colspan="6">I3.5
</td>
<td style="text-align:left;background:white"><b>rI3</b>, Index 3
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td style="background:white" colspan="18">&#160;
</td>
<td colspan="1">±
</td>
<td colspan="6">I4.4
</td>
<td colspan="6">I4.5
</td>
<td style="text-align:left;background:white"><b>rI4</b>, Index 4
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td style="background:white" colspan="18">&#160;
</td>
<td colspan="1">±
</td>
<td colspan="6">I5.4
</td>
<td colspan="6">I5.5
</td>
<td style="text-align:left;background:white"><b>rI5</b>, Index 5
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td style="background:white" colspan="18">&#160;
</td>
<td colspan="1">±
</td>
<td colspan="6">I6.4
</td>
<td colspan="6">I6.5
</td>
<td style="text-align:left;background:white"><b>rI6</b>, Index 6
</td></tr>
<tr>
<td colspan="32"><b>Program counter</b>
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td style="background:white" colspan="19">&#160;
</td>
<td colspan="6">J4
</td>
<td colspan="6">J5
</td>
<td style="text-align:left;background:white"><b>rJ</b>, Jump
</td></tr>
<tr>
<td colspan="32"><b>Condition code flags</b>
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td style="background:white" colspan="30">&#160;
</td>
<td colspan="1">O
</td>
<td style="background:white; color:black;">Overflow flag
</td></tr>
<tr style="background:silver;color:black;text-align:center">
<td style="background:white" colspan="29">&#160;
</td>
<td colspan="2"><tt>&lt;=&gt;</tt>
</td>
<td style="background:white; color:black;">Comparison flag
</td></tr></tbody></table>
</td></tr></tbody></table>

2. Command
- 문자열: OP ADRESS,I(F) <br/>
    ex) LDA 2000,2(0:3)
- 물리적 구조:
<table style="text-align:center;margin-left:0.5in">
<tbody><tr>
<td style="width:15px;"><sup>3</sup><sub>0</sub>
</td>
<td style="width:15px;"><sup>2</sup><sub>9</sub>
</td>
<td style="width:15px;"><sup>2</sup><sub>8</sub>
</td>
<td style="width:15px;"><sup>2</sup><sub>7</sub>
</td>
<td style="width:15px;"><sup>2</sup><sub>6</sub>
</td>
<td style="width:15px;"><sup>2</sup><sub>5</sub>
</td>
<td style="width:15px;"><sup>2</sup><sub>4</sub>
</td>
<td style="width:15px;"><sup>2</sup><sub>3</sub>
</td>
<td style="width:15px;"><sup>2</sup><sub>2</sub>
</td>
<td style="width:15px;"><sup>2</sup><sub>1</sub>
</td>
<td style="width:15px;"><sup>2</sup><sub>0</sub>
</td>
<td style="width:15px;"><sup>1</sup><sub>9</sub>
</td>
<td style="width:15px;"><sup>1</sup><sub>8</sub>
</td>
<td style="width:15px;"><sup>1</sup><sub>7</sub>
</td>
<td style="width:15px;"><sup>1</sup><sub>6</sub>
</td>
<td style="width:15px;"><sup>1</sup><sub>5</sub>
</td>
<td style="width:15px;"><sup>1</sup><sub>4</sub>
</td>
<td style="width:15px;"><sup>1</sup><sub>3</sub>
</td>
<td style="width:15px;"><sup>1</sup><sub>2</sub>
</td>
<td style="width:15px;"><sup>1</sup><sub>1</sub>
</td>
<td style="width:15px;"><sup>1</sup><sub>0</sub>
</td>
<td style="width:15px;"><sup>0</sup><sub>9</sub>
</td>
<td style="width:15px;"><sup>0</sup><sub>8</sub>
</td>
<td style="width:15px;"><sup>0</sup><sub>7</sub>
</td>
<td style="width:15px;"><sup>0</sup><sub>6</sub>
</td>
<td style="width:15px;"><sup>0</sup><sub>5</sub>
</td>
<td style="width:15px;"><sup>0</sup><sub>4</sub>
</td>
<td style="width:15px;"><sup>0</sup><sub>3</sub>
</td>
<td style="width:15px;"><sup>0</sup><sub>2</sub>
</td>
<td style="width:15px;"><sup>0</sup><sub>1</sub>
</td>
<td style="width:15px;"><sup>0</sup><sub>0</sub>
</td></tr>
<tr>
<td colspan="1" style="background-color:#CCC">±
</td>
<td colspan="12" style="background-color:#CCC">Address
</td>
<td colspan="6" style="background-color:#CCF">Index
</td>
<td colspan="6" style="background-color:#CEC">Modification
</td>
<td colspan="6" style="background-color:#FCC">Operation
</td></tr></tbody></table>

