import pandas as pd
import matplotlib.pyplot as plt


df = pd.read_csv(
    "src/resources/dataset/dataset.csv",
    encoding='latin1',
    delimiter=';',
    usecols=[
        "Cod_Mun", "Mun", "Referência", "Pes_PBF", "Pes_Cad",
        "F_PBF_Domi", "F_PBF_EP", "F_CAD_EP"
    ]
)

# de vazio p 'none'
df.fillna('none', inplace=True)

# mapping dos meses para o formato MM/YY
meses = {
    'jan': '01', 'fev': '02', 'mar': '03', 'abr': '04',
    'mai': '05', 'jun': '06', 'jul': '07', 'ago': '08',
    'set': '09', 'out': '10', 'nov': '11', 'dez': '12'
}

# coluna referencia: jan/20 -> 01/20
df['Referência'] = df['Referência'].str.split('/').apply(
    lambda x: f"{meses[x[0]]}/{x[1][-2:]}"
)

# concat do Cod_Mun + Referência (tirando a /)
df['Cod_Mun'] = df['Cod_Mun'].astype(str) + df['Referência'].str.replace('/', '')

print(df.head())
print(df.tail())
print("---------------------------------------------------------------------------------------------")

# filtrando por dados de 2020 
df_2020 = df[df['Referência'].str.endswith('20')]

print(df_2020.head())
print(df_2020.tail())

# ajustando data type pra evitar erros no java
df_2020.loc[:, 'Pes_PBF'] = df_2020['Pes_PBF'].astype(float)
df_2020.loc[:, 'Pes_Cad'] = df_2020['Pes_Cad'].astype(float)
df_2020.loc[:, 'F_PBF_Domi'] = df_2020['F_PBF_Domi'].str.replace(',', '.').astype(float)
df_2020.loc[:, 'F_PBF_EP'] = df_2020['F_PBF_EP'].str.strip().replace('', '0').astype(float)
df_2020.loc[:, 'F_CAD_EP'] = df_2020['F_CAD_EP'].astype(float)


df_2020.to_csv("src/resources/dataset/dataset_2020_cleaned.csv", index=False)

