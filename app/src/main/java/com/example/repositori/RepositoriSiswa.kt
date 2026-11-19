package com.example.roomdb.repositori

import com.example.roomdb.room.Siswa
import com.example.roomdb.room.SiswaDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)

    // Edit 1 : tambah 3 fungsi berikut
    fun getSiswaStream(id: Int): Flow<Siswa?>

    suspend fun deleteSiswa(siswa: Siswa)

    suspend fun updateSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(private val siswaDao: SiswaDao) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    
    override suspend fun insertSiswa(siswa: Siswa) = withContext(Dispatchers.IO) {
        siswaDao.insert(siswa)
    }

    // edit 2 : tambah 3 override berikut
    override fun getSiswaStream(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id)
    
    override suspend fun deleteSiswa(siswa: Siswa) = withContext(Dispatchers.IO) {
        siswaDao.delete(siswa)
    }
    
    override suspend fun updateSiswa(siswa: Siswa) = withContext(Dispatchers.IO) {
        siswaDao.update(siswa)
    }
}
