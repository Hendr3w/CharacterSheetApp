import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.example.charactersheetapp.Tav


@Dao
interface TavDao {

    // Método para inserir um novo personagem
    @Insert
    suspend fun insert(tav: Tav)

    // Método para buscar todos os personagens
    @Query("SELECT * FROM character_table")
    suspend fun getAllTavs(): List<Tav>

    // Método para buscar um personagem por ID
    @Query("SELECT * FROM character_table WHERE id = :id")
    suspend fun getTavById(id: Int): Tav?

    // Método para atualizar um personagem existente
    @Update
    suspend fun update(tav: Tav)

    // Método para deletar um personagem
    @Delete
    suspend fun delete(tav: Tav)

    // Método para deletar todos os personagens
    @Query("DELETE FROM character_table")
    suspend fun deleteAll()
}
