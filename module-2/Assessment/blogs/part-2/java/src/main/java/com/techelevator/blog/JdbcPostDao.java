package com.techelevator.blog;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcPostDao implements PostDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcPostDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Post newPost) {
		// Implement this method to save post to database
		String savePostSql = "INSERT INTO posts (name, body, published, created) "
				+ " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(savePostSql, newPost.getName(),
				newPost.getBody(), newPost.isPublished(), newPost.getCreated());
	}

	@Override
	public List<Post> getAllPosts() {
		// Implement this method to pull in all posts from database
		List<Post> posts = new ArrayList<Post>();

		String sql = "SELECT posts.id, posts.name, posts.body, posts.published, posts.created "
				+ " FROM posts;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()) {
			posts.add(mapRowToPost(results));
		}

		return posts;
	}

	private Post mapRowToPost(SqlRowSet results) {
		Post postRow = new Post();
		postRow.setId(results.getLong("id"));
		postRow.setName(results.getString("name"));
		postRow.setBody(results.getString("body"));
		postRow.setPublished(results.getBoolean("published"));

		Date createdDate = results.getDate("created");
		if (createdDate == null) {
			postRow.setCreated(null);
		} else {
			postRow.setCreated(createdDate.toLocalDate());
		}

		return postRow;
	}

}
