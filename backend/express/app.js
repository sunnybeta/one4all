const express = require('express')
const index = require('./routers/index')

app = express()

app.use("/_internal_", index)

const PORT = 8080

app.get("/healthcheck", (req,res) => {
	res.send({status: "healthy"})
})

app.listen(PORT, () => console.log(`Listening on port ${PORT}`))
