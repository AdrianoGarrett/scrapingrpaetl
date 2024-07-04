####Projeto de Scraping, ETL e RPA em um Site de Venda de Produtos Online - KABUM####

Descrição do Projeto
Este projeto visa realizar scraping, ETL (Extract, Transform, Load) e RPA (Robotic Process Automation) no site de venda de produtos online KABUM. Utilizando conceitos de SOLID, API REST e Spring Boot, o projeto demonstra conhecimentos em banco de dados, programação Java com Spring Boot, uso de threads, padrões de projeto e um fluxo de dados.

Funcionalidades
    O projeto possui as seguintes funcionalidades principais:

Consulta de Produto:
        Endpoint: /iniciscrapper/kabum/
        Método: POST
        Formato da Requisição: JSON
                {
                    "produtoDesejado": "placa de video"
                }
                
Retorno:
    Um campo chamado "taskId" que é um UUID para identificar a consulta solicitada.
                {
                    "taskId": "b9670dcd-f38c-42b8-a2a8-3fdf8c85b78f"
                }
            
Obtenção do Resultado da Consulta:
        Endpoint: /iniciascrapper/getResultById
        Método: POST
        Formato da Requisição: JSON
                {
                    "taskId": "b9670dcd-f38c-42b8-a2a8-3fdf8c85b78f"
                }
Retorno: 
        Se a consulta do scraping já tiver sido realizada, o resultado será retornado em formato JSON com um array de produtos encontrados no site da KABUM.
                {
                    "resultado": [
                        {
                            "valorProdutoAvista": "7.999,99",
                            "urlProduto": "https://www.kabum.com.br//produto/520528/placa-de-video-rtx-4080-super-msi-16g-ventus-3x-oc-nvidia-geforce-16gb-gddr6x-dlss-ray-tracing",
                            "descricaoProduto": "Placa de Vídeo RTX 4080 Super MSI 16G Ventus 3X OC NVIDIA GeForce, 16GB GDDR6X, DLSS, Ray Tracing"
                        },
                        {
                            "valorProdutoAvista": "6.899,99",
                            "urlProduto": "https://www.kabum.com.br//produto/547106/placa-de-video-rtx-4070-ti-super-ventus-3x-oc-msi-nvidia-geforce-16gb-gddr6x-912-v513-627",
                            "descricaoProduto": "Placa de Vídeo RTX 4070 TI Super Ventus 3X OC MSI NVIDIA GeForce, 16GB GDDR6X - 912-V513-627"
                        },
                        {
                            "valorProdutoAvista": "4.159,99",
                            "desconto": 898.8198,
                            "urlProduto": "https://www.kabum.com.br//produto/520536/placa-de-video-rtx-4070-super-msi-12g-ventus-2x-oc-nvidia-geforce-12gb-gddr6x-dlss-ray-tracing",
                            "valorProduto": "5.058,81",
                            "descricaoProduto": "Placa de Vídeo RTX 4070 Super MSI 12G Ventus 2X OC NVIDIA GeForce, 12GB GDDR6X, DLSS, Ray Tracing"
                        }
                    ],
                    "produtoDesejado": "placa de video",
                    "taskId": "b9670dcd-f38c-42b8-a2a8-3fdf8c85b78f"
                }
Caso o taskId não seja encontrado, o retorno será:
                {
                    "mensagem": "Nenhum valor encontrado para o taskId informado."
                }
Tecnologias Utilizadas
            Linguagem de Programação: Java
            Framework: Spring Boot
            Padrões de Projeto: SOLID
            API REST: Implementação de endpoints para integração
            Threads: Uso de threads para processamento paralelo
            Banco de Dados: Persistência de dados das consultas realizadas
            Como Executar o Projeto

Considerações Finais:
        Este projeto, embora simples, demonstra uma série de conhecimentos importantes no desenvolvimento de aplicações Java com Spring Boot, integração com APIs REST, utilização de threads e implementação de padrões de projeto. Sinta-se à vontade para explorar e modificar o código conforme necessário.
