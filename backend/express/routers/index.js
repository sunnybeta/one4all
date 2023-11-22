const router = require('express').Router()


router.get("/healthcheck", (req, res) => {
	res.send({status: "healthy"})
})


module.exports = router
