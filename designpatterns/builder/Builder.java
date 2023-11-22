public class Builder {
	public static void main(String[] args) {
		UrlBuilder urlBuilder = new UrlBuilder();
		urlBuilder.protocol("https://").domain("localhost").port("8080");
		Url url = new Url(urlBuilder);

		System.out.println(url.protocol);
		System.out.println(url.domain);
		System.out.println(url.port);
		System.out.println(url.section);
	}
}

public class UrlBuilder {
	public String protocol;
	public String subDomain;
	public String domain;
	public String tld;
	public String port;
	public String path;
	public String query;
	public String section;
	
	UrlBuilder protocol(String protocol) {
		this.protocol = protocol;
		return this;
	}
	
	UrlBuilder subDomain(String subDomain) {
		this.subDomain = subDomain;
		return this;
	}
	
	UrlBuilder domain(String domain) {
		this.domain = domain;
		return this;
	}
	
	UrlBuilder port(String port) {
		this.port = port;
		return this;
	}
	
	UrlBuilder tLD(String tld) {
		this.tld = tld;
		return this;
	}
	
	UrlBuilder path(String path) {
		this.path = path;
		return this;
	}
	
	UrlBuilder query(String query) {
		this.query = query;
		return this;
	}
	
	UrlBuilder section(String section) {
		this.section = section;
		return this;
	}
}

public class Url {
	public String protocol;
	public String subDomain;
	public String domain;
	public String tld;
	public String port;
	public String path;
	public String query;
	public String section;

	public Url(UrlBuilder urlBuilder) {
		this.protocol  = urlBuilder.protocol;
		this.subDomain = urlBuilder.subDomain;
		this.domain    = urlBuilder.domain;
		this.tld       = urlBuilder.tld;
		this.port      = urlBuilder.port;
		this.path      = urlBuilder.path;
		this.query     = urlBuilder.query;
		this.section   = urlBuilder.section;
	}
}

