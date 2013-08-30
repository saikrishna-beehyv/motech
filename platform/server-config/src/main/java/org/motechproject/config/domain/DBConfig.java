package org.motechproject.config.domain;

import org.apache.commons.lang.StringUtils;
import org.motechproject.config.MotechConfigurationException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * <p>DBConfig encapsulates the database configuration, composed of as db url, username and password.</p>
 */
public class DBConfig {
    private final String url;
    private String username;
    private String password;

    /**
     *
     * @param url
     * @param username
     * @param password
     * @throws MotechConfigurationException if given url is invalid.
     */
    public DBConfig(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        validate();
    }

    private void validate() {
        if (StringUtils.isBlank(url)) {
            throw new MotechConfigurationException("Motech DB URL cannot be null or empty.");
        }

        try {
            URL urlObject = new URL(url);
            urlObject.toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new MotechConfigurationException("Motech DB URL is not a valid http URL.", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DBConfig dbConfig = (DBConfig) o;

        if (password != null ? !password.equals(dbConfig.password) : dbConfig.password != null) {
            return false;
        }

        if (!url.equals(dbConfig.url)) {
            return false;
        }

        if (username != null ? !username.equals(dbConfig.username) : dbConfig.username != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = url.hashCode();
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DBConfig{");
        sb.append("url='").append(url).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
