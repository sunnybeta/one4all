package main

import (
	"fmt"
	"net/http"
	"github.com/gin-gonic/gin"
)

func main() {
	router := gin.Default()
	PORT := 8080
	router.GET("/_internal_/healthcheck", healthcheck)
	fmt.Println("Server Starting on port %v", PORT)
	router.Run("localhost:8080")
}

func healthcheck(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{"status": "healthy"})
}
