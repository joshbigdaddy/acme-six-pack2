package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Comment;

import repositories.CommentRepository;

@Service
@Transactional
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	// Supporting Services

	// Constructor

	public CommentService() {
		super();
	}

	public Comment create() {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		Comment g;
		g = new Comment();
		return g;
	}

	public Comment findOne(int gId) {
		Comment result;

		result = commentRepository.findOne(gId);

		return result;
	}

	public Collection<Comment> findAll() {
		return commentRepository.findAll();
	}

	public void save(Comment g) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);
		commentRepository.save(g);
	}

	public void delete(Comment g) {
		// Administrator administrator=administratorService.findByPrincipal();
		// Assert.notNull(administrator);

		commentRepository.delete(g);

	}

	// Other bussines methods
}