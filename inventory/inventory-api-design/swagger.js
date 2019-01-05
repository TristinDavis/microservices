const hostname = '127.0.0.1';
const port = 3000;

const express = require('express');
const app = express();
const swaggerUi = require('swagger-ui-express');
const YAML = require('yamljs');
const swaggerDocument = YAML.load('./docs/products.yml');


app.use('/docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument, {}, ));

app.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/docs`);
});